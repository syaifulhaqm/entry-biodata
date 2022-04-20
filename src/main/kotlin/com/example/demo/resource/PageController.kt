package com.example.demo.resource

import com.example.demo.constant.EBloodGroup
import com.example.demo.constant.EGender
import com.example.demo.dto.OptionDTO
import com.example.demo.service.impl.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@Controller
class PageController(
    private val userService: UserService,
    private val mapper: ObjectMapper
) {

    @GetMapping("")
    fun index() = "index"

    @GetMapping("sign-up")
    fun signUp() = "sign-up"

    @GetMapping("form-apply")
    fun formApply(model: Model): String {
        model.addAttribute("genders", EGender.values().map { OptionDTO(it.name, it.desc) })
        model.addAttribute("bloodGroups", EBloodGroup.values().map { OptionDTO(it.name, it.name) })
        model.addAttribute(
            "readyToBePlaces", listOf(
                OptionDTO(true, "Ya"),
                OptionDTO(false, "Tidak")
            )
        )
        return "form-apply"
    }

    @GetMapping("success")
    fun success() = "success"

    @GetMapping("admin/list")
    fun adminList(model: Model): String {
        model.set("data", userService.getAllBiodata())
        return "list"
    }

    @GetMapping("admin/detail/{id}")
    fun adminViewDetail(@PathVariable id:UUID, model: Model): String {
        model.addAttribute("genders", EGender.values().map { OptionDTO(it.name, it.desc) })
        model.addAttribute("bloodGroups", EBloodGroup.values().map { OptionDTO(it.name, it.name) })
        model.addAttribute(
            "readyToBePlaces", listOf(
                OptionDTO(true, "Ya"),
                OptionDTO(false, "Tidak")
            )
        )
        model.addAttribute("biodata", mapper.writeValueAsString(userService.getByID(id)))
        return "form-detail"
    }

}