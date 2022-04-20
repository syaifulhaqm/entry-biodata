package com.example.demo.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "experiences")
data class Experience(

    @Id @GeneratedValue
    var id: UUID? = null,

    var companyName: String = "",
    var lastPosition: String = "",
    var latsSalary: Double = 0.0,
    var year: Int = 0
)
