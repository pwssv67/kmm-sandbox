import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.pwssv67.sandbox.App
import org.jetbrains.skiko.wasm.onWasmReady
import org.pwssv67.sandbox.di.initDI

fun main() {
    initDI()
    Napier.base(DebugAntilog())
    onWasmReady {
        BrowserViewportWindow("KMM Client Sandbox") {
            Box(modifier = Modifier.fillMaxWidth()) {
                Box(Modifier.width(800.dp).align(Alignment.Center)) {
                    App()
                }
            }
        }
    }
}
