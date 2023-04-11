package org.pwssv67.sandbox.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.pwssv67.sandbox.main.data.LinkProviderImpl
import org.pwssv67.sandbox.openUrl

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        val links = remember { LinkProviderImpl.getLinks() }

        Text(
            text = "Egor Smolianinov",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(16.dp)
        )

        links.forEach {
            SiteLink(link = it.url, text = it.title, icon = { /*TODO*/})
        }
    }
}

@Composable
private fun SiteLink(link: String, text: String, icon: @Composable () -> Unit) {
    TextButton(
        onClick = { openUrl(link) },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors()
    ) {
        icon()
        Text(text)
    }
}
