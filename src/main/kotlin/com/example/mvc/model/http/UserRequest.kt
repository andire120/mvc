package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (
    var name:String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,
    var phoneNumber:String?=null  // phone_number
)
/*
{
    "result_code" : "OK",
    "result_message" : "성공",
    "description" : "~~~",
    "user" : [
        {   "name" : " ",
            "age" : "",
            "email" : ""
        },

        {   "name" : " ",
            "age" : "",
            "email" : ""
        },
    ]
}
*
/*
{
    "name" : "noel",
    "age" : "23",
    "email" : "andire@gmail.com",
    "address" : "멘체스터",
    "phone_number" : "010-4567-8910",
}
 */