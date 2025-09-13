package com.example.weighnix.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

/*CREATE TABLE user_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
   login_id INT not null,
   lpg_perc INT not null,
   time datetime not null,
   foreign key (login_id) references login(id)
);*/

@Entity
@Table(name = "user_history")
data class History(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id :Int = 0,

    @ManyToOne
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    val loginId: Login,

    @Column(name = "lpg_perc")
    val lpgPerc:Int,

    @Column(name = "time")
    val time: LocalDateTime = LocalDateTime.now()
)