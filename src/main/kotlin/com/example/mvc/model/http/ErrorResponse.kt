package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.ControllerAdvice
import java.time.LocalDateTime

@ControllerAdvice
data class ErrorResponse(

    @field:JsonProperty("result_code")
    var resultCode: String?=null,

    @field:JsonProperty("http_status")
    var httpStatus: String? = null,

    @field:JsonProperty("http_method")
    var httpMethod:String?=null,

    var message: String? = null,

    var path: String? = null,
    var timestamp: LocalDateTime?=null,
    var errors: MutableList<Error>?= mutableListOf()
)

data class Error(
    var field:String?=null,
    var message: String?=null,
    var value:Any?=null
)