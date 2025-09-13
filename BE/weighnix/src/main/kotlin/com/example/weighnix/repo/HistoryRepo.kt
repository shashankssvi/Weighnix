package com.example.weighnix.repo

import com.example.weighnix.entity.History
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface HistoryRepo: JpaRepository<History,Int> {

    @Query("select h from History h where h.loginId.id=:loginId")
    fun getByLoginId(@Param("loginId") loginId:Int): List<History>
}