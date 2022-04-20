package com.example.demo.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    var id: UUID? = null,

    var email: String = "",
    var password: String = "",

)
