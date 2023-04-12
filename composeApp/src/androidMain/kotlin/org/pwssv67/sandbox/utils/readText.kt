package org.pwssv67.sandbox.utils

import dev.icerock.moko.resources.FileResource
import org.pwssv67.sandbox.AndroidApp

actual suspend fun FileResource.readText(): String {
    return this.readText(AndroidApp.INSTANCE)
}