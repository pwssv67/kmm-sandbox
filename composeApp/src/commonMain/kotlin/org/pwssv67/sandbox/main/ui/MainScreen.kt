package org.pwssv67.sandbox.main.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.pwssv67.sandbox.main.data.AboutRepository
import org.pwssv67.sandbox.main.di.MainProvider
import org.pwssv67.sandbox.openUrl
import org.pwssv67.sandbox.utils.rememberDeferredState

@Composable
fun MainScreen(repository: AboutRepository = MainProvider.aboutRepository) {

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {

        val links by rememberDeferredState { repository.getLinks() }
        val description by rememberDeferredState { repository.getDescription() }

        Text(
            text = "Egor Smolianinov",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = description ?: "Loading...",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "Used technologies:",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier.wrapContentHeight().fillMaxWidth()
        ) {
            items(15) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.size(96.dp).background(Color.Gray))
                    Text("Kotlin Multiplatform", textAlign = TextAlign.Center, modifier = Modifier.width(IntrinsicSize.Min))
                }
            }
        }

        links?.forEach {
            SiteLink(link = it.url, text = it.title, icon = { /*TODO*/})
        }
    }
}

@Composable
private fun SiteLink(link: String, text: String, icon: @Composable () -> Unit) {
    TextButton(
        onClick = { openUrl(link) },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.outlinedButtonColors()
    ) {
        icon()
        Text(text)
    }
}
