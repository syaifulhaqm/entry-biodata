package com.example.demo.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class LoginRequest(
    @field:Email
    var email: String = "",

    @field:NotBlank
    var password: String = ""
)
