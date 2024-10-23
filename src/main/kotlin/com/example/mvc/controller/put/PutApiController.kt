package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserReponse
import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        //0. Response
        UserReponse().apply {
            // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            //2. description
            this.description = "-------------"
        }.apply {
            //3. user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "liam"
                this.age = 28
                this.email = "andire@gmail.com"
                this.address = "맨체스터"
                this.phoneNumber = "010-4567-8910"
            })

            userList.add(UserRequest().apply {
                this.name = "Noel"
                this.age = 23
                this.email = "dnfire@gmail.com"
                this.address = "맨체스터"
                this.phoneNumber = "010-1234-5678"
            })

            this.userRequest = userList
        }

        return userRequest
    }



}