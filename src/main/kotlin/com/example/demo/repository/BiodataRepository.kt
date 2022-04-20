package com.example.demo.repository

import com.example.demo.model.Biodata
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BiodataRepository : JpaRepository<Biodata, UUID> {
    fun findBySendApplicationTrue(): List<Biodata>

}