package org.pwssv67.sandbox.utils

import dev.icerock.moko.resources.FileResource

actual suspend fun FileResource.readText(): String {
    return this.readText()
}