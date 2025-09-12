package com.example.weighnix.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

/*
* CREATE TABLE login (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(40) NOT NULL UNIQUE,
    phone_number VARCHAR(11) NOT NULL,
    address VARCHAR(100) NOT NULL
);
*/

@Entity
@Table(name = "login")
data class Login(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,

    @Column(name = "name")
    val name:String,

    @Column(name = "email")
    val email:String,

    @Column(name = "phone_number")
    val phoneNumber:String,

    @Column(name = "address")
    val address:String
)
