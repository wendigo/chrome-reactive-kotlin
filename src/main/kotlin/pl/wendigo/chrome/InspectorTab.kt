package pl.wendigo.chrome

internal data class InspectorTab(
        val description: String,
        val devtoolsFrontendUrl: String,
        val id: String,
        val title: String,
        val type: String,
        val url: String,
        val webSocketDebuggerUrl: String
)