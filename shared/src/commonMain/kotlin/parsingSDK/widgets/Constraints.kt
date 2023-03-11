package parsingSDK.widgets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import parsingSDK.models.WidgetType


typealias Constraints = HashMap<String, String>

const val ID = "property_id"
const val TYPE = "property_type"

const val PADDING_LEFT = "property_padding_left_text"
const val PADDING_RIGHT = "property_padding_right_text"
const val PADDING_TOP = "property_padding_top_text"
const val PADDING_BOTTOM = "property_padding_bottom_text"

const val MARGIN_LEFT = "property_margin_left_text"
const val MARGIN_RIGHT = "property_margin_right_text"
const val MARGIN_TOP = "property_margin_top_text"
const val MARGIN_BOTTOM = "property_margin_bottom_text"

const val TEXT = "property_text"
const val GRAVITY = "property_gravity"

fun Constraints.padding(): PaddingValues {
    val start = get(PADDING_LEFT)?.toIntOrNull() ?: 0
    val top = get(PADDING_TOP)?.toIntOrNull() ?: 0
    val right = get(PADDING_RIGHT)?.toIntOrNull() ?: 0
    val bottom = get(PADDING_BOTTOM)?.toIntOrNull() ?: 0
    return PaddingValues(start = start.dp, top = top.dp, end = right.dp, bottom = bottom.dp)
}

fun Constraints.margin(): PaddingValues {
    val start = get(MARGIN_LEFT)?.toIntOrNull() ?: 0
    val top = get(MARGIN_TOP)?.toIntOrNull() ?: 0
    val right = get(MARGIN_RIGHT)?.toIntOrNull() ?: 0
    val bottom = get(MARGIN_BOTTOM)?.toIntOrNull() ?: 0
    return PaddingValues(start = start.dp, top = top.dp, end = right.dp, bottom = bottom.dp)
}

fun Constraints.id(): String? = get(ID)
fun Constraints.type(): WidgetType {
    return when (get(TYPE)) {
        "button" -> WidgetType.BUTTON
        "image_button" -> WidgetType.IMAGE_BUTTON
        "image" -> WidgetType.IMAGE
        "text" -> WidgetType.TEXT
        "horizontal_list" -> WidgetType.HORIZONTAL_LIST
        "vertical_list" -> WidgetType.VERTICAL_LIST
        "vertical_scroll" -> WidgetType.VERTICAL_SCROLL
        "horizontal_scroll" -> WidgetType.HORIZONTAL_SCROLL
        else -> WidgetType.EMPTY
    }
}

fun Constraints.text(): String = get(TEXT) ?: ""


