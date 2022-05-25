package com.github.anthonyjclark.idealix

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

// TODO(ajc): does this serve any purpose?
class LixStartup : StartupActivity.DumbAware {

    private var alreadyInitialized: Boolean = false

    override fun runActivity(project: Project) {
        if (alreadyInitialized) return

        alreadyInitialized = true
        LixState.enabled = true

        LixState.LOGGER.debug("Lix::runActivity startup complete")
    }


}