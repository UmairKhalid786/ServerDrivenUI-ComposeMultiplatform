package parsingSDK.widgets

data class SingleChildWidget(
    val childWidgets: List<Widget>,
    override val constraints: Constraints
) : Widget(constraints)