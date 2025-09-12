package com.example.weighnix.repo

import com.example.weighnix.entity.Login
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepo: JpaRepository<Login,Int> {

}