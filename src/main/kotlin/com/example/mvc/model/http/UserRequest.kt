package com.example.mvc.model.http

import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8, message = "이름은 2-8 사이")
    var name: String?=null,

    @field:PositiveOrZero // 0 < 숫자를 검증 0도 포함(양수)
    var age: Int?=null,

    @field:Email  //email 양식
    var email: String?=null,

    @field:NotBlank //공백을 검증
    var address: String?=null,

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") //정규식 검증
    var phoneNumber: String?=null,  // phone_number

    var createdAt:String?=null
) {

    @AssertTrue(message = "생일자의 패턴은 yyyy-MM-dd HH:mm:ss")
    private fun isValidCreateAt():Boolean {
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e:Exception) {
            false
        }
    }
}
