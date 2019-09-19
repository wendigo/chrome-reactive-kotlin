package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.target.TargetInfo

fun TargetInfo.isPage() = this.type == "page"