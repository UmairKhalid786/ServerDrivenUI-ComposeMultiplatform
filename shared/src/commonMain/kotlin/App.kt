import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.techlads.sdu.parsingSDK.Parser
import com.techlads.sdu.parsingSDK.widgets.*
import com.techlads.sdu.parsingSDK.widgets.Widget
import parsingSDK.widgets.*

@Composable
internal fun App() {
    MaterialTheme {
        Parser(horizontalList())
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
        put(TEXT, "Text")
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
