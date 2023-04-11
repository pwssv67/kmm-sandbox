import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.pwssv67.sandbox.App
import org.jetbrains.skiko.wasm.onWasmReady
import org.pwssv67.sandbox.di.initDI

fun main() {
    initDI()
    onWasmReady {
        BrowserViewportWindow("KMM Client Sandbox") {
            Box(modifier = Modifier.width(800.dp), contentAlignment = Alignment.Center) {
                App()
            }
        }
    }
}
