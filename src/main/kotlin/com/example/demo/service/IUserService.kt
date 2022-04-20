package com.example.demo.service

import com.example.demo.dto.BiodataDTO
import com.example.demo.dto.LoginRequest
import com.example.demo.model.Biodata
import java.util.*

interface IUserService {
    fun login(request: LoginRequest): UUID
    fun signUp(request: LoginRequest)
    fun sendApplication(request: Biodata)

    fun getAllBiodata(): List<BiodataDTO>
    fun getByID(biodateId: UUID): Biodata
}