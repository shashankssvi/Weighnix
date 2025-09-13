package com.example.weighnix.service

import com.example.weighnix.dto.HistoryDto
import com.example.weighnix.entity.History
import com.example.weighnix.entity.Login
import com.example.weighnix.repo.HistoryRepo
import com.example.weighnix.repo.LoginRepo
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class HistoryService(private val historyRepo: HistoryRepo,private val loginRepo: LoginRepo) {

    fun getAll(): Any {
        val data = historyRepo.findAll()
        return if (data.isEmpty()){
            ResponseEntity.noContent()
        }
        else{
            ResponseEntity.ok(data)
        }
    }

    fun getByLoginId(loginId:Int):Any{
        val data = historyRepo.getByLoginId(loginId = loginId)
        return if (data.isEmpty()){
            ResponseEntity.noContent()
        }
        else{
            ResponseEntity.ok(data)
        }
    }

    fun addHistory(historyDto: HistoryDto): Any{
        val login1 = loginRepo.findById(historyDto.loginId).map { Login(
            id = it.id,
            name = it.name,
            email = it.email,
            phoneNumber = it.phoneNumber,
            address = it.address
        ) }.orElse(null)
        val history = History(
            loginId = login1,
            lpgPerc = historyDto.lpgPerc,
            time = historyDto.time
        )
        val data1 = historyRepo.save(history)
        return if (data1==null){
            ResponseEntity.noContent()
        }
        else{
            ResponseEntity.ok(data1)
        }
    }
}