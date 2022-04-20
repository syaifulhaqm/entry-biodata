package com.example.demo.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "trainings")
data class Training(
    @Id @GeneratedValue
    var id: UUID? = null,
    var name: String = "",
    var certificateExist: Boolean = true,
    var year: Int = 0
)
