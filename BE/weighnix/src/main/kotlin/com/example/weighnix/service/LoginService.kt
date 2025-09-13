package com.example.weighnix.service

import com.example.weighnix.entity.Login
import com.example.weighnix.repo.LoginRepo
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import kotlin.collections.isNotEmpty


@Service
class LoginService(private val loginRepo: LoginRepo) {

    fun getAll(): Any {
        val data = loginRepo.findAll()
        return if (data.isNotEmpty()){
            ResponseEntity.ok(data)
        }
        else{
            ResponseEntity.noContent()
        }
    }

    fun getById(id:Int): Any {
        val data = loginRepo.findById(id)
        return if (data.isEmpty){
            ResponseEntity.noContent()
        }
        else{
            ResponseEntity.ok(data)
        }
    }

    fun postLogin(login: Login): Any {
        val data = loginRepo.save(login)
        return if (data!=null){
            ResponseEntity.ok(data)
        }
        else{
            ResponseEntity.noContent()
        }
    }
}