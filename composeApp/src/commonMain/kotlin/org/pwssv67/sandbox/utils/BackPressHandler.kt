package org.pwssv67.sandbox.utils

import androidx.compose.runtime.Composable

@Composable
expect fun BackPressHandler(enabled: Boolean, onBack: () -> Unit)