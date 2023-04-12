package org.pwssv67.sandbox.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import kotlinx.browser.window
import org.w3c.dom.events.Event

@Composable
actual fun BackPressHandler(enabled: Boolean, onBack: () -> Unit) {
    val eventListener: (Event) -> Unit = {
        if (enabled) {
            onBack()
        }
    }
    DisposableEffect(Unit) {
        window.addEventListener("popstate", eventListener)
        onDispose {
            window.removeEventListener("popstate", eventListener)
        }
    }
}