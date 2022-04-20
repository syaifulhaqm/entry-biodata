package com.example.demo.dto

import com.example.demo.model.Biodata
import java.util.*

class BiodataDTO(
    val id: UUID,
    val name: String,
    val pdob: String,
    val position: String
) {
    companion object {
        fun of(data: Biodata): BiodataDTO {
            return BiodataDTO(
                id = data.id!!,
                name = data.name,
                pdob = data.pdob,
                position = data.position
            )
        }
    }
}