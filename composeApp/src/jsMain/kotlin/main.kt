import org.pwssv67.sandbox.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        BrowserViewportWindow("KMM Client Sandbox") {
            App()
        }
    }
}
