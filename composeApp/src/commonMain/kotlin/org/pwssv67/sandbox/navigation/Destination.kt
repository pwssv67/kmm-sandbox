package org.pwssv67.sandbox.navigation

import androidx.compose.runtime.Composable
import org.pwssv67.sandbox.main.data.TechnologyInfo
import org.pwssv67.sandbox.main.ui.MainScreen
import org.pwssv67.sandbox.main.ui.TechnologyAbout

sealed interface Destination {
    @Composable
    fun render(navigatable: Navigatable)


    object Main : Destination {
        @Composable
        override fun render(navigatable: Navigatable) {
            navigatable.MainScreen()
        }
    }

    class Technology(private val technology: TechnologyInfo) : Destination {
        @Composable
        override fun render(navigatable: Navigatable) {
            navigatable.TechnologyAbout(technology)
        }
    }
}