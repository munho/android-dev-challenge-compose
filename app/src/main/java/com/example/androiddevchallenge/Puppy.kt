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

import androidx.annotation.DrawableRes

data class Puppy(
    val puppyId: Int,
    val title: String,
    @DrawableRes val imageThumbId: Int,
    val url: String,
    val subtitle: String
)

val puppyList = arrayListOf(
    Puppy(
        puppyId = 0,
        title = "Golden Retriever",
        imageThumbId = R.drawable.golden_retriever,
        url = "https://en.wikipedia.org/wiki/File:Golde33443.jpg",
        subtitle = "The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties.[3] The name \"retriever\" refers to the breed's ability to retrieve shot game undamaged due to their soft mouth. Golden retrievers have an instinctive love of water, and are easy to train to basic or advanced obedience standards. They are a long-coated breed, with a dense inner coat that provides them with adequate warmth in the outdoors, and an outer coat that lies flat against their bodies and repels water. Golden retrievers are well suited to residency in suburban or country environments.[4] They shed copiously, particularly at the change of seasons, and require fairly regular grooming. The Golden Retriever was originally bred in Scotland in the mid-19th century."
    ),
    Puppy(
        puppyId = 1,
        title = "Basset Hound",
        imageThumbId = R.drawable.basset_hound,
        url = "https://en.wikipedia.org/wiki/File:Cara_de_quem_caiu_do_caminh%C3%A3o..._(cropped).jpg",
        subtitle = "The Basset Hound is a short-legged breed of dog in the hound family. The Basset is a scent hound that was originally bred for the purpose of hunting hare. Their sense of smell and ability to ground-scent is second only to the Bloodhound.[1]\n" +
            "\n" +
            "Basset Hounds are one of six recognised \"basset\"-type breeds in France. The name basset is derived from the French word bas, meaning 'low', with the attenuating suffix -et—together meaning 'rather low'. Basset Hounds are usually bicolours or tricolours of standard hound colouration. "
    ),
    Puppy(
        puppyId = 2, "Welsh Springer Spaniels",
        imageThumbId = R.drawable.welsh_springer_spaniels,
        url = "https://en.wikipedia.org/wiki/File:New_born_pups.JPG",
        subtitle = "The Welsh Springer Spaniel (Cymraeg: Llamgi Cymru) is a breed of dog and a member of the spaniel family. Thought to be comparable to the old Land Spaniel, they are similar to the English Springer Spaniel and historically have been referred to as both the Welsh Spaniel and the Welsh Cocker Spaniel. They were relatively unknown until a succession of victories in dog trials by the breed increased its popularity. Following recognition by The Kennel Club in 1902, the breed gained the modern name of Welsh Springer Spaniel. The breed's coat only comes in a single colour combination of white with red markings, usually in a piebald pattern. Loyal and affectionate, they can become very attached to family members and are wary of strangers. Health conditions are limited to those common among many breeds of dog, although they are affected more than average by hip dysplasia and some eye conditions. They are a working dog, bred for hunting, and while not as rare as some varieties of spaniel, they are rarer than the more widely known English Springer Spaniel with which they are sometimes confused. "
    ),
    Puppy(
        puppyId = 3, "Australian Cattle Dog ",
        imageThumbId = R.drawable.cattle_dog,
        url = "https://en.wikipedia.org/wiki/File:ACD_Silverbarn%27s_Ronja_x.jpg",
        subtitle = "The Australian Cattle Dog (ACD), or simply Cattle Dog, is a breed of herding dog originally developed in Australia for droving cattle over long distances across rough terrain. This breed is a medium-sized, short-coated dog that occurs in two main colour forms. It has either brown or black hair distributed fairly evenly through a white coat, which gives the appearance of a \"red\" or \"blue\" dog. "
    ),
    Puppy(
        puppyId = 4, "Westie pups ",
        imageThumbId = R.drawable.westie_pups,
        url = "https://en.wikipedia.org/wiki/File:Westie_pups.jpg",
        subtitle = "Smart, confident, and always entertaining at play, the adorable West Highland White Terrier (Westie, for short) has charmed owners for over 300 years. This diminutive but sturdy earthdog is among the most popular of the small terriers. "
    )
)

// private val puppyList: List<Puppy> = List(10) {
//    Puppy(it, "name #$it", R.drawable.ic_launcher_background)
// }

object PetRepo {
    fun getPets(): List<Puppy> = puppyList
}

object PetArgumentKey {
    val puppyId = "puppyId"
}
