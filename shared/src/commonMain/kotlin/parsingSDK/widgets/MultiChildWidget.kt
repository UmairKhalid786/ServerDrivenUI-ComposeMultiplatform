package com.techlads.sdu.parsingSDK.widgets

import parsingSDK.widgets.Constraints

class MultiChildWidget(
    val childWidget: List<Widget>,
    override val constraints: Constraints
) : Widget(constraints)