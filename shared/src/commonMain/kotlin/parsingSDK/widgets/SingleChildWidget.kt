package com.techlads.sdu.parsingSDK.widgets

import parsingSDK.widgets.Constraints

data class SingleChildWidget(
    val childWidgets: List<Widget>,
    override val constraints: Constraints
) : Widget(constraints)