package org.pwssv67.sandbox.main.data

interface LinkProvider {
    fun getLinks(): List<ProfileLink>
}

expect object LinkProviderImpl: LinkProvider