package org.pwssv67.sandbox.main.data

actual object LinkProviderImpl : LinkProvider {
    override fun getLinks(): List<ProfileLink> {
        return listOf(
            ProfileLink.github,
            ProfileLink.linkedIn,
            ProfileLink.googlePlay
        )
    }
}