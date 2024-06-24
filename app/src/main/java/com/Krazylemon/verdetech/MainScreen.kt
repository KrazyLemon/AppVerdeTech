package com.Krazylemon.verdetech

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.Krazylemon.verdetech.pages.AjustesPage
import com.Krazylemon.verdetech.pages.ChatBotPage
import com.Krazylemon.verdetech.pages.HistorialPage
import com.Krazylemon.verdetech.pages.InicioPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier){

    val navItemList = listOf(
        NavItem("Ajutes",Icons.Default.Settings),
        NavItem("Inicio", Icons.Default.Home),
        NavItem("ChatBot", Icons.Default.Email),
        NavItem("Historial", Icons.Default.ExitToApp),
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                 TopAppBar(
                     title = { 
                         Text(
                             text = "Bienvenido",
                             fontSize = 48.sp
                         )
                     },
                     actions = {
                       IconButton(onClick = { /*TODO*/ }) {
                           Icon(
                               imageVector = Icons.Default.AccountCircle,
                               contentDescription = "Cuenta"
                           )
                       }  
                     }
                 )
        },
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed{ index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                                  selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier, selectedIndex : Int) {
    when(selectedIndex){
        0-> AjustesPage()
        1-> InicioPage()
        2-> ChatBotPage()
        3-> HistorialPage()
    }
}
