package com.techlads.sdu.parsingSDK.widgets

import parsingSDK.widgets.Constraints
import parsingSDK.widgets.Widget

data class SingleChildWidget(
    val childWidgets: List<Widget>,
    override val constraints: Constraints
) : Widget(constraints)