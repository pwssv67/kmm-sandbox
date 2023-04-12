package org.pwssv67.sandbox.utils

import dev.icerock.moko.resources.FileResource

expect suspend fun FileResource.readText(): String