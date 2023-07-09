package com.example.ventasboletas.data.repository

import com.example.ventasboletas.data.EventosApi
import javax.inject.Inject
class ConsumirApi @Inject constructor(
    private val api: EventosApi

){
    suspend fun geAllapi() = api.geteventos()
}