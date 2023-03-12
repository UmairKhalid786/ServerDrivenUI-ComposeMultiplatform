package com.techlads.sdu.parsingSDK.models

sealed class WidgetType {
    object EMPTY: WidgetType()
    object BUTTON: WidgetType()
    object IMAGE_BUTTON: WidgetType()
    object TEXT: WidgetType()
    object HORIZONTAL_LIST: WidgetType()
    object VERTICAL_LIST: WidgetType()
    object IMAGE: WidgetType()
    object HORIZONTAL_SCROLL: WidgetType()
    object VERTICAL_SCROLL: WidgetType()
}
