/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Profile : Screen("profile", R.string.profile)
    object PetsList : Screen("pets_list", R.string.puppies_list)
}

@Composable
fun Home(navController: NavController) {
    val pets = remember { PetRepo.getPets() }
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = { AppBar() }
        ) { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                item {
                    Header(stringResource(R.string.popular))
                }
                items(pets) { pet ->
                    PetItem(navController = navController, puppy = pet)
                    Divider(startIndent = 72.dp)
                }
            }
        }
    }
}

@Composable
fun Profile(navController: NavController, petId: Int?) {
    val pets = remember { PetRepo.getPets() }
    val pet = pets.first {
        it.puppyId == petId
    }

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                AppBar(
                    title = "Profile",
                    imageVector = Icons.Rounded.ArrowBack,
                    navController = navController
                )
            }

        ) { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                item {
                    Header(stringResource(R.string.popular))
                }
                item {
                    PetItem(navController = navController, puppy = pet, detailView = true)
                    Divider(startIndent = 72.dp)
                }
            }
        }
    }
}

@Composable
private fun AppBar(
    title: String = stringResource(R.string.app_title),
    imageVector: ImageVector = Icons.Rounded.Palette,
    navController: NavController? = null
) {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 12.dp),

            )
        },
        title = {
            Text(text = title)
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        actions = {
            // navController?.popBackStack()
        }
    )
}

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
        contentColor = MaterialTheme.colors.primary,
        modifier = modifier.semantics { heading() }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PetItem(
    navController: NavController,
    puppy: Puppy,
    modifier: Modifier = Modifier,
    detailView: Boolean = false
) {
    ListItem(
        modifier = modifier
            .clickable {
                showDetail(navController = navController, puppy = puppy)
            }
            .padding(vertical = 8.dp),
        icon = {
            Image(
                painter = painterResource(puppy.imageThumbId),
                contentDescription = null,
                modifier = Modifier.clip(shape = MaterialTheme.shapes.small)
            )
        },
        text = {
            Text(text = puppy.title)
        },
        secondaryText = {
            Text(
                text = when (detailView) {
                    true -> puppy.subtitle
                    false -> puppy.url
                }
            )
        }
    )
}

fun showDetail(navController: NavController, puppy: Puppy) {
    navController.navigate("profile/${puppy.puppyId}")
}
