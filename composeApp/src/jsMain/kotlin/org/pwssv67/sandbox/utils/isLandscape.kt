package org.pwssv67.sandbox.utils

import androidx.compose.runtime.Composable
import kotlinx.browser.window

@Composable
actual fun isLandscape(): Boolean {
    return window.innerWidth > window.innerHeight
}