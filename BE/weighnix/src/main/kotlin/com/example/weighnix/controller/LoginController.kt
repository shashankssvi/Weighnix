package com.example.weighnix.controller

import com.example.weighnix.entity.Login
import com.example.weighnix.service.LoginService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("login")
class LoginController(private val loginService: LoginService) {

    @GetMapping("/get")
    fun getAll(): Any {
        return loginService.getAll()
    }

    @GetMapping("/get/{id}")
    fun getAll(@PathVariable id:Int): Any {
        return loginService.getById(id=id)
    }

    @PostMapping("/add")
    fun postLogin(@RequestBody login: Login):Any{
        return loginService.postLogin(login = login)
    }

}