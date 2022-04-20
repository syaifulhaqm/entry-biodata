package com.example.demo.resource

import com.example.demo.dto.LoginRequest
import com.example.demo.model.Biodata
import com.example.demo.service.IUserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("user")
class UserRestController(
    private val service: IUserService
) {

    @ExceptionHandler(RuntimeException::class)
    fun handleException(e: RuntimeException) = ResponseEntity.badRequest().body(e.message)

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody @Valid request: LoginRequest) = service.login(request)

    @PostMapping("sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody @Valid request: LoginRequest) = service.signUp(request)

    @PostMapping("apply")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun sendApplication(@RequestBody @Valid request: Biodata) = service.sendApplication(request)

    @GetMapping("admin/application")
    @ResponseStatus(HttpStatus.OK)
    fun getAllApplication() = service.getAllBiodata()

    @GetMapping("admin/application/{biodateId}")
    @ResponseStatus(HttpStatus.OK)
    fun getByID(@PathVariable biodateId: UUID) = service.getByID(biodateId)
}