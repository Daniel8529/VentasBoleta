package com.example.ventasboletas.data
import com.example.ventasboletas.data.DTO.Eventosresponsidto
import retrofit2.http.GET

interface EventosApi {
    @GET("Eventos/")
    suspend fun geteventos(): List<Eventosresponsidto>
}

