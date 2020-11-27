package com.example.teacherkotlinproject.models

import java.io.Serializable


data class Contact(
    var image: String,
    var firstName: String,
    var lastName: String,
    var email: String
): Serializable


var contactArray = mutableListOf<Contact>().apply {
    add(Contact("https://pullman.accor.com/destinations/city/riga-1400x788-1.jpg", "Бернард", "Корт", "bern_kort@gmail.com"))
    add(Contact("https://www.projectcasting.com/wp-content/uploads/2014/09/Jim-Carrey.jpg", "Бернард", "Корт", "bern_kort@gmail.com"))
    add(Contact("https://www.biography.com/.image/ar_8:10%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_620/MTU3NzgxMzUyMDMxMjAwNDky/_kj-apa-attends-foxs-teen-choice-awards-at-the-forum-on-august-12-2018-in-inglewood-california-photo-by-jon-kopaloff_filmmagic-square.jpg", "Бернард", "Корт", "bern_kort@gmail.com"))
    add(Contact("", "Бернард", "Корт", "bern_kort@gmail.com"))
    add(Contact("", "Бернард", "Корт", "bern_kort@gmail.com"))
    add(Contact("", "Бернард", "Корт", "bern_kort@gmail.com"))
}