package parsingSDK

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import parsingSDK.models.WidgetType
import parsingSDK.widgets.*

@Composable
internal fun Parser(widget: Widget, modifier: Modifier = Modifier) {
    when (widget.constraints.type()) {
        WidgetType.BUTTON -> {
            ParserButton(widget, modifier)
        }
        WidgetType.TEXT -> {
            ParserText(widget, modifier)
        }
        WidgetType.HORIZONTAL_LIST -> {
            HorizontalList(widget as? MultiChildWidget ?: return, modifier)
        }
        WidgetType.VERTICAL_LIST -> {
            VerticalList(widget as? MultiChildWidget ?: return, modifier)
        }
        WidgetType.HORIZONTAL_SCROLL -> {
            HorizontalScroll(widget as? MultiChildWidget ?: return, modifier)
        }
        WidgetType.VERTICAL_SCROLL -> {
            VerticalScroll(widget as? MultiChildWidget ?: return, modifier)
        }
        else -> {
            Text("No widget found")
        }
    }
}

@Composable
internal fun ParserButton(widget: Widget, modifier: Modifier = Modifier) {
    val constraints = remember { widget.constraints }
    Button(onClick = {}, modifier = modifier.setGeneralProperties(widget.constraints)) {
        Text(constraints.text())
    }
}

@Composable
internal fun ParserText(widget: Widget, modifier: Modifier = Modifier) {
    val constraints = remember { widget.constraints }
    Text(constraints.text(), modifier.setGeneralProperties(widget.constraints))
}

@Composable
internal fun HorizontalList(widget: MultiChildWidget, modifier: Modifier = Modifier) {
    val widgets = remember { widget.childWidget }
    LazyRow(modifier = modifier.setGeneralProperties(widget.constraints)) {
        items(widgets.size) {
            Parser(widgets[it])
        }
    }
}

@Composable
internal fun VerticalList(widget: MultiChildWidget, modifier: Modifier = Modifier) {
    val widgets = remember { widget.childWidget }
    LazyColumn(modifier = modifier.setGeneralProperties(widget.constraints)) {
        items(widgets.size) {
            Parser(widgets[it])
        }
    }
}

@Composable
internal fun VerticalScroll(widget: MultiChildWidget, modifier: Modifier = Modifier) {
    val widgets = remember { widget.childWidget }
    Column(modifier = modifier.setGeneralProperties(widget.constraints)) {
        repeat(widget.childWidget.size) {
            Parser(widgets[it])
        }
    }
}

@Composable
internal fun HorizontalScroll(widget: MultiChildWidget, modifier: Modifier = Modifier) {
    val widgets = remember { widget.childWidget }
    Row(modifier = modifier.setGeneralProperties(widget.constraints)) {
        repeat(widget.childWidget.size) {
            Parser(widgets[it])
        }
    }
}

internal fun Modifier.setGeneralProperties(constraints: Constraints): Modifier {
    constraints.id()?.let { testTag(it) }
    return padding(constraints.padding())
        .padding(constraints.margin())
}
