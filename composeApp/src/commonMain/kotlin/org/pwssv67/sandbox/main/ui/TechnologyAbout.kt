package org.pwssv67.sandbox.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import io.github.aakira.napier.Napier
import io.github.aakira.napier.log
import org.pwssv67.sandbox.MR
import org.pwssv67.sandbox.main.data.TechnologyInfo
import org.pwssv67.sandbox.navigation.Destination
import org.pwssv67.sandbox.navigation.Navigatable
import org.pwssv67.sandbox.utils.BackPressHandler
import org.pwssv67.sandbox.utils.ImageUtils
import org.pwssv67.sandbox.utils.isLandscape

@Composable
fun Navigatable.TechnologyAbout(technology: TechnologyInfo) {

    BackPressHandler(enabled = true) {
        this.navigateTo(Destination.Main)
    }

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
        Text(
            text = technology.title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )
        val imageFile = technology.image?.let { ImageUtils.getImageByName(it) }

        val landscape = isLandscape()
        if (landscape) {
            LandscapeLayout(imageFile, technology)
        } else {
            PortraitLayout(imageFile, technology)
        }

        TextButton(
            onClick = { this@TechnologyAbout.navigateTo(Destination.Main) },
            modifier = Modifier.padding(16.dp).fillMaxWidth().align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(MR.strings.back))
        }
    }
}

@Composable
private fun LandscapeLayout(
    imageFile: ImageResource?,
    technology: TechnologyInfo
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        imageFile?.let {
            Image(
                painter = painterResource(it),
                contentDescription = technology.title,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.weight(1f).padding(16.dp)
            )
        }
        Column(modifier = Modifier.weight(2f).padding(16.dp)) {
            Text(
                text = technology.description ?: "",
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
private fun PortraitLayout(
    imageFile: ImageResource?,
    technology: TechnologyInfo
) {
    imageFile?.let {
        Image(
            painter = painterResource(it),
            contentDescription = technology.title,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
    }

    Text(
        text = technology.description ?: "",
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}