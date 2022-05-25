package com.github.anthonyjclark.idealix.action

import com.github.anthonyjclark.idealix.LixState
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareToggleAction

class LixToggleEnableAction : DumbAwareToggleAction() /*, LightEditCompatible*/ {

    // TODO(ajc): per editor?
    override fun isSelected(e: AnActionEvent): Boolean = LixState.enabled

    override fun setSelected(e: AnActionEvent, state: Boolean) {
        LixState.enabled = state
    }

}