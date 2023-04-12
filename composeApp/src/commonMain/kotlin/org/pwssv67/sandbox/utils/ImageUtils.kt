package org.pwssv67.sandbox.utils

import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.getImageByFileName
import org.pwssv67.sandbox.MR

object ImageUtils {
    fun getImageByName(name: String): ImageResource? {
        //awful workaround for the fact that moko has a different filenames for different platforms. For js it's "file.extension", for Android - just "file"
        return MR.images.getImageByFileName(name) ?: MR.images.getImageByFileName(
            name.stripFilenameFromExtension()
        )
    }

    private fun String.stripFilenameFromExtension(): String {
        return this.substringBeforeLast(".")
    }
}