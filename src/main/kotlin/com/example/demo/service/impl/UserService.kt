package com.example.demo.service.impl

import com.example.demo.dto.BiodataDTO
import com.example.demo.dto.LoginRequest
import com.example.demo.model.Biodata
import com.example.demo.model.User
import com.example.demo.repository.BiodataRepository
import com.example.demo.repository.UserRepository
import com.example.demo.service.IUserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val biodataRepository: BiodataRepository
) : IUserService {
    override fun login(request: LoginRequest): UUID {
        return userRepository.findByEmailAndPassword(
            request.email,
            request.password
        )?.id
            ?: throw RuntimeException("Email/Password tidak valid")
    }

    override fun signUp(request: LoginRequest) {
        // Check Email
        userRepository.findByEmail(
            request.email
        )?.let { throw RuntimeException("Email sudah terdaftar") }

        // Save User
        val data = User(email = request.email, password = request.password)
        userRepository.save(data)
    }

    override fun sendApplication(request: Biodata) {
        request.user?.id.takeIf { it != null }
            ?.let { userID ->
                // Update data user
                userRepository.findById(userID)
                    .map {
                        request.sendApplication = true
                        biodataRepository.save(request)
                    }
                    .orElseThrow { RuntimeException("ID User tidak valid") }
            }
            ?: throw RuntimeException("ID User tidak valid")
    }

    override fun getAllBiodata(): List<BiodataDTO> = biodataRepository.findBySendApplicationTrue().map { BiodataDTO.of(it) }

    override fun getByID(biodateId: UUID): Biodata {
        return biodataRepository.findById(biodateId)
            .orElseThrow { throw RuntimeException("Email sudah terdaftar") }
    }
}