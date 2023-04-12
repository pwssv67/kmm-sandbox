package org.pwssv67.sandbox.navigation

/*
context for ensuring that local composition has a navigateTo function
 */
fun interface Navigatable {
    fun navigateTo(destination: Destination)
}