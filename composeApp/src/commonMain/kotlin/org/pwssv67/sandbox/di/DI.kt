package org.pwssv67.sandbox.di

import org.koin.core.context.startKoin
import org.pwssv67.sandbox.main.di.mainScreenModule

//init koin di
fun initDI() = startKoin {
    modules(
        mainScreenModule
    )
}