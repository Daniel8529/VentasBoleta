package com.example.ventasboletas.ui.List

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ventasboletas.data.DTO.Eventosresponsidto
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.icons.Icons
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage



@Composable
fun ListScreen(
    viewModel:  ListViewModel  = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta")}, modifier = Modifier.padding(2.dp), actions = {})

        },
        floatingActionButton = {

        }
    ) {


        val uiState by viewModel.uiState.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {

            EntidadApiList(
                Eventos = uiState.eventos,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }


    }

}



@Composable
fun EntidadApiList(
    Eventos:List<Eventosresponsidto>,
    viewModel: ListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(Eventos) {evento ->
            EntidadApiRow(evento, viewModel)
        }
    }
}

@Composable
fun EntidadApiRow(eventosresponsidto: Eventosresponsidto, viewModel: ListViewModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = "${eventosresponsidto.Image}",
                contentDescription = null
            )

        }

        Text(
            text ="Nombre:${eventosresponsidto.Nombre}",
            style = MaterialTheme.typography.h6
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Fecha: ${eventosresponsidto.Fecha}"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Ciudad: ${eventosresponsidto.Ciudad}"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Lugar: ${eventosresponsidto.Lugar}"
            )

        }







        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}