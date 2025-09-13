package com.example.weighnix.dto

import java.time.LocalDateTime

data class HistoryDto (
    val loginId: Int,
    val lpgPerc:Int,
    val time: LocalDateTime
)