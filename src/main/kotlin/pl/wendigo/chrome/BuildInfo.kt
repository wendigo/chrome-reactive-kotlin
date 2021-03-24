package pl.wendigo.chrome

import kotlinx.serialization.Serializable

@Serializable
data class BuildInfo(
    val version: String,
    val revision: String,
    val branch: String,
    val group: String,
    val name: String) {
    override fun toString(): String {
        return "$group:$name:$version built from $branch, rev $revision"
    }
}
