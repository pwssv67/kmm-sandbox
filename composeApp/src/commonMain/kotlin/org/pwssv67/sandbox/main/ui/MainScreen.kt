package org.pwssv67.sandbox.main.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import dev.icerock.moko.resources.getImageByFileName
import org.pwssv67.sandbox.MR
import org.pwssv67.sandbox.main.data.AboutRepository
import org.pwssv67.sandbox.main.data.Technology
import org.pwssv67.sandbox.main.di.MainProvider
import org.pwssv67.sandbox.openUrl
import org.pwssv67.sandbox.utils.rememberDeferredState

@Composable
fun MainScreen(repository: AboutRepository = MainProvider.aboutRepository) {

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {

        val links by rememberDeferredState { repository.getLinks() }
        val description by rememberDeferredState { repository.getDescription() }
        val technologies by rememberDeferredState { repository.getTechnologies() }

        Text(
            text = stringResource(MR.strings.name),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = description ?: stringResource(MR.strings.loading),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = stringResource(MR.strings.used_technologies),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp)
        )

        technologies?.let { TechnologiesList(it) }

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

@Composable
private fun TechnologiesList(list: List<Technology>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier.wrapContentHeight().fillMaxWidth()
    ) {
        //TODO: loop this list
        items(list) {
            TechnologyItem(technology = it)
        }
    }
}

@Composable
private fun TechnologyItem(technology: Technology) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val imageResource = getImageByName(technology.image ?: "")
        if (imageResource != null) {
            Image(painter = painterResource(imageResource), null, Modifier.size(96.dp))
        } else {
            Spacer(modifier = Modifier.size(96.dp).background(Color.Gray))
        }
        Text(technology.title, textAlign = TextAlign.Center, modifier = Modifier.width(IntrinsicSize.Min))
    }
}

private fun getImageByName(name: String): ImageResource? {
    return MR.images.getImageByFileName(name)
}