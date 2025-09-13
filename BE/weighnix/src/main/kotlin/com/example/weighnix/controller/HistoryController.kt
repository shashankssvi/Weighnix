package com.example.weighnix.controller

import com.example.weighnix.dto.HistoryDto
import com.example.weighnix.service.HistoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("history")
class HistoryController(private val historyService: HistoryService) {

    @GetMapping("/get")
    fun getAll(): Any{
        return historyService.getAll()
    }

    @GetMapping("/get/{loginId}")
    fun getByLoginId(@PathVariable loginId:Int): Any{
        return historyService.getByLoginId(loginId = loginId)
    }

    @PostMapping("/add")
    fun addHistory(@RequestBody historyDto: HistoryDto): Any{
        return historyService.addHistory(historyDto=historyDto)
    }
}