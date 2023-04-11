import androidx.compose.ui.window.ComposeUIViewController
import org.pwssv67.sandbox.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
