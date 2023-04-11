package org.pwssv67.sandbox.utils

import androidx.compose.runtime.*

//This thing is highly discouraged in production. For all the good things, don't use this. Just use viewmodel or mvi.
@Composable
inline fun <T> rememberDeferredState(crossinline block: suspend () -> T): State<T?> {
    val state = remember { mutableStateOf<T?>(null) }
    LaunchedEffect(Unit) {
        state.value =  block()
    }
    return state
}