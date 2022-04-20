package com.example.demo.model

import com.example.demo.constant.EBloodGroup
import com.example.demo.constant.EGender
import java.time.OffsetDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "biodatas")
data class Biodata(
    @Id @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    var id: UUID? = null,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User? = null,

    var sendApplication: Boolean = false,

    var position: String = "",
    var name: String = "",
    var noKTP: String = "",
    var pdob: String = "",

    @Enumerated(EnumType.STRING)
    var gender: EGender = EGender.MALE,

    var religion: String = "",

    @Enumerated(EnumType.STRING)
    var bloodGroup: EBloodGroup? = null,

    var status: String = "",
    var addressKTP: String = "",
    var addressHome: String = "",
    var email: String = "",
    var phone: String = "",
    var closePerson: String = "",

    @OneToMany
    var educations: List<Education>? = null,

    @OneToMany
    var trainings: List<Training>? = null,

    @OneToMany
    var experiences: List<Experience>? = null,

    var skill: String = "",
    var readyToBePlace: Boolean = false,
    var expectedSalary: Double = 0.0,

    var createdAt: OffsetDateTime = OffsetDateTime.now()
)
