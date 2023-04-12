package org.pwssv67.sandbox.main.data

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.pwssv67.sandbox.MR
import org.pwssv67.sandbox.utils.readText


interface AboutRepository {
    suspend fun getDescription(): String
    suspend fun getLinks(): List<ProfileLink>
    suspend fun getTechnologies(): List<TechnologyInfo>
}

class AboutRepositoryImpl(): AboutRepository {
    override suspend fun getDescription(): String {
        //return hardcoded string until I'll make a server
        return "Motivated Android developer with 3 years of experience designing and building mobile applications for Android devices. Expert in Server-Driven UI and Build Systems with training in Cross-Platform mobile application development, proficient with Kotlin and Java, as well as with Android SDK. Passionate about staying up-to-date with the latest industry trends and technologies, what can be seen in this application.\n\n\nThis is simultaneously a website, an Android and an iOS app, all from one codebase, built from scratch."
        //TODO("Not yet implemented")
    }

    override suspend fun getLinks(): List<ProfileLink> {
        return LinkProviderImpl.getLinks()
    }

    override suspend fun getTechnologies(): List<TechnologyInfo> {
        return Json.decodeFromString(MR.files.technology_list.readText())
    }
}