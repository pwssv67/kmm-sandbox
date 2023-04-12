package org.pwssv67.sandbox.navigation

import androidx.compose.runtime.*

@Composable
fun AppNavigation(destination: Destination = Destination.Main) {
    var currentDestination by remember { mutableStateOf<Destination>(destination) }
    val navigatable = Navigatable { newDestination ->
        currentDestination = newDestination
    }
    currentDestination.render(navigatable)
}