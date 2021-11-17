package com.example.coffeshopapp.models

data class User(
    val password : String,
    val username : String,
    val name : String,
    val phone : String,
    val address : String,
)

val testUser1 = User(
    "12345",
    "user1",
    "Александра Гесс",
    "+7(951)822-65-12",
    "г.Обнинск, пр.Ленина, 69"
);

