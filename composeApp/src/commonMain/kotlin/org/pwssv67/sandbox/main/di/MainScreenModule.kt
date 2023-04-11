package org.pwssv67.sandbox.main.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module
import org.pwssv67.sandbox.main.data.AboutRepository
import org.pwssv67.sandbox.main.data.AboutRepositoryImpl

val mainScreenModule = module {
    single<AboutRepository> { AboutRepositoryImpl() }
}


@Deprecated("workaround until https://github.com/InsertKoinIO/koin/issues/1559 is fixed. Delete and use koin-compose instead")
internal object MainProvider: KoinComponent {
    val aboutRepository: AboutRepository by inject()
}