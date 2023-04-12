package org.pwssv67.sandbox.main.data

import kotlinx.serialization.Serializable

@Serializable
data class TechnologyInfo(
    val title: String,
    val image: String?,
    val description: String?
)
