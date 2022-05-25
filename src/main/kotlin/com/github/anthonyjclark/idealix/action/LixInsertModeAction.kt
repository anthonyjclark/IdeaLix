package com.github.anthonyjclark.idealix.action

import com.github.anthonyjclark.idealix.LixState
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbAwareAction

class LixInsertModeAction : DumbAwareAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val editor: Editor = e.getRequiredData(CommonDataKeys.EDITOR)
        LixState.editorStates[editor]?.insertMode()
    }

}