package com.example.mvc.controller.resposne

import com.example.mvc.model.http.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ResponseApiController {

    // 1. get 4xx
    @GetMapping("")
    fun getMapping(@RequestParam age : Int?): ResponseEntity<String> {

        return age?.let {
            // age not null
            if(it < 20) {
                return ResponseEntity.status(400).body("age 값은 20보다 커야 합니다.")
            }

            ResponseEntity.ok("OK")
        }?: kotlin.run {
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        /*
        // 1. age == null -> 400 error
        if (age == null) {
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        //2. age < 20 -> 400 error
        if(age < 20) {
            return ResponseEntity.status(400).body("age 값이 20보다 커야합니다.")
        }
        */


    }

    //2. post 200

    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?):ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest) //object mapper -> object -> jspm
    }

    //3. put 201

    //4. delete 500
}