import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import parsingSDK.Parser
import parsingSDK.widgets.*

@Composable
internal fun App() {
    MaterialTheme {
        val widget = remember { horizontalList() }
        Parser(widget)
    }
}

fun horizontalList(): Widget {
    val button = Widget(constraints = hashMapOf<String, String>().apply {
        put(TEXT, "Hello")
        put(ID, "1")
        put(TYPE, "button")
        put(PADDING_BOTTOM, "5")
        put(PADDING_TOP, "5")
        put(PADDING_LEFT, "5")
        put(PADDING_RIGHT, "5")
    })

    val text = Widget(constraints = hashMapOf<String, String>().apply {
        put(TEXT, "HiHi")
        put(ID, "2")
        put(TYPE, "text")
        put(PADDING_BOTTOM, "5")
        put(PADDING_TOP, "5")
        put(PADDING_LEFT, "5")
        put(PADDING_RIGHT, "5")
    })

    val verticalList =
        MultiChildWidget(listOf(button, text), constraints = hashMapOf<String, String>().apply {
            put(ID, "3")
            put(TYPE, "horizontal_list")
            put(PADDING_BOTTOM, "5")
            put(PADDING_TOP, "5")
            put(PADDING_LEFT, "5")
            put(PADDING_RIGHT, "5")
        })

    return verticalList
}


expect fun getPlatformName(): String