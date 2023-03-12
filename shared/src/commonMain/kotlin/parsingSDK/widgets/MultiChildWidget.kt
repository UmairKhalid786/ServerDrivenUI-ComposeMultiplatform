package parsingSDK.widgets

class MultiChildWidget(
    val childWidget: List<Widget>,
    override val constraints: Constraints
) : Widget(constraints)