import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import parsingSDK.widgets.Widget
import parsingSDK.Parser
import parsingSDK.widgets.*

@Composable
internal fun App() {
    MaterialTheme {
        Parser(testingHorizontalList())
    }
}

fun testingHorizontalList(): Widget {
    val button = Widget(constraints = hashMapOf<String, String>().apply {
        put(TEXT, "Hello")
        put(ID, "1")
        put(TYPE, "button")
        put(PADDING_BOTTOM, "5")
        put(PADDING_TOP, "5")
        put(PADDING_LEFT, "5")
        put(PADDING_RIGHT, "5")
        put(WIDTH, MATCH_PARENT.toString())
        put(HEIGHT, WRAP_CONTENT.toString())
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
            put(WIDTH, MATCH_PARENT.toString())
            put(HEIGHT, MATCH_PARENT.toString())
        })

    return verticalList
}
