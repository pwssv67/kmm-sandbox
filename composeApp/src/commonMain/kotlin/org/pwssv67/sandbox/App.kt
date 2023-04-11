package org.pwssv67.sandbox

import androidx.compose.runtime.Composable
import org.pwssv67.sandbox.main.ui.MainScreen

@Composable
internal fun App() = AppTheme {
    MainScreen()
}

internal expect fun openUrl(url: String?)