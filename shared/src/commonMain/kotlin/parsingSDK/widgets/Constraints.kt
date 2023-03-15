package parsingSDK.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import parsingSDK.models.WidgetType
import parsingSDK.utils.HexToJetpackColor


typealias Constraints = HashMap<String, String>

const val MATCH_PARENT = -1
const val WRAP_CONTENT = -2

const val ID = "property_id"
const val TYPE = "property_type"

const val HEIGHT = "property_height"
const val WIDTH = "property_width"

const val PADDING_LEFT = "property_padding_left_text"
const val PADDING_RIGHT = "property_padding_right_text"
const val PADDING_TOP = "property_padding_top_text"
const val PADDING_BOTTOM = "property_padding_bottom_text"

const val MARGIN_LEFT = "property_margin_left_text"
const val MARGIN_RIGHT = "property_margin_right_text"
const val MARGIN_TOP = "property_margin_top_text"
const val MARGIN_BOTTOM = "property_margin_bottom_text"

const val BORDER_RADIUS_ALL = "property_border_radius"

const val BORDER_TOP_LEFT = "property_border_top_left_radius"
const val BORDER_TOP_RIGHT = "property_border_top_right_radius"
const val BORDER_BOTTOM_LEFT = "property_border_bottom_left_radius"
const val BORDER_BOTTOM_RIGHT = "property_border_bottom_right_radius"

const val BORDER_STROKE_WIDTH = "property_border_width"
const val BORDER_STROKE_COLOR = "property_border_color"

const val TEXT = "property_text"
const val GRAVITY = "property_gravity"

const val TRANSPARENT_COLOR = "#00000000"

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

fun Constraints.borderStroke(): BorderStroke {
    val width = get(BORDER_STROKE_WIDTH)?.toIntOrNull() ?: 0
    val color = getColor(BORDER_STROKE_COLOR)
    return BorderStroke(width.dp, color)
}

fun Constraints.shape(): RoundedCornerShape? {
    val all = get(BORDER_RADIUS_ALL)?.toIntOrNull() ?: -1

    val tl = get(BORDER_TOP_LEFT)?.toIntOrNull() ?: all
    val tr = get(BORDER_TOP_RIGHT)?.toIntOrNull() ?: all
    val bl = get(BORDER_BOTTOM_LEFT)?.toIntOrNull() ?: all
    val br = get(BORDER_BOTTOM_RIGHT)?.toIntOrNull() ?: all

    if (tl == -1 &&
        tr == -1 &&
        br == -1 &&
        bl == -1
    ) return null

    return RoundedCornerShape(
        topStart = tl.dp,
        topEnd = tr.dp,
        bottomStart = bl.dp,
        bottomEnd = br.dp
    )
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

fun Constraints.height(): Int = get(HEIGHT)?.toIntOrNull() ?: WRAP_CONTENT
fun Constraints.width(): Int = get(WIDTH)?.toIntOrNull() ?: WRAP_CONTENT
fun Constraints.getColor(property: String): Color =
    HexToJetpackColor.getColor(get(property) ?: TRANSPARENT_COLOR)


