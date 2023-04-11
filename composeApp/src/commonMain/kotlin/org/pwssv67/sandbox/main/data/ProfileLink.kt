package org.pwssv67.sandbox.main.data

data class ProfileLink(
    val title: String = "",
    val url: String = "",
    val imageId:String = "",
) {
    companion object {
        val github = ProfileLink(
            title = "Github",
            url = "https://github.com/pwssv67",
            imageId = "" //TODO
        )

        val linkedIn = ProfileLink(
            title = "LinkedIn",
            url = "https://linkedin.com/in/pwssv67",
            imageId = "" //TODO
        )

        val website = ProfileLink(
            title = "Website",
            url = "https://", //TODO
            imageId = "" //TODO
        )

        val googlePlay = ProfileLink(
            title = "Google Play",
            url = "https://", //TODO
            imageId = "" //TODO
        )
    }
}