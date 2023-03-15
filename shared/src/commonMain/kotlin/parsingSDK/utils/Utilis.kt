package parsingSDK.utils

import androidx.compose.ui.graphics.Color

internal object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(colorString.removePrefix("#").toLong(16) or 0x00000000FF000000)
    }
}