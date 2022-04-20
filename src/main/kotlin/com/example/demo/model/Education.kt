package com.example.demo.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "educations")
data class Education(
    @Id @GeneratedValue
    var id: UUID? = null,
    var level: String = "",
    var name: String = "",
    var major: String = "",
    var graduateYear: Int = 0,
    var gpa: Double = 0.0
)
