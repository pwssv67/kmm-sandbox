package org.pwssv67.sandbox

import androidx.compose.runtime.Composable
import org.pwssv67.sandbox.navigation.AppNavigation
import org.pwssv67.sandbox.navigation.Destination

@Composable
internal fun App() = AppTheme {
    AppNavigation(Destination.Main)
}

internal expect fun openUrl(url: String?)