package com.github.anthonyjclark.idealix

import com.github.anthonyjclark.idealix.LixState.commandKeymap
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CustomShortcutSet
import com.intellij.openapi.actionSystem.ex.ActionUtil
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbAwareAction
import java.awt.event.KeyEvent

class LixEditorKeymapActions(private val editor: Editor) : DumbAwareAction() {

    private val shortcutSet = CustomShortcutSet(*commandKeymap.keys.toTypedArray())

    init {
        commandMode()
    }

    fun commandMode() {
        registerCustomShortcutSet(shortcutSet, editor.contentComponent)
    }

    fun insertMode() {
        unregisterCustomShortcutSet(editor.contentComponent)
    }

    override fun actionPerformed(e: AnActionEvent) {
        val keyCode = (e.inputEvent as KeyEvent).keyCode
        val action = commandKeymap[keyCode] ?: return

        ActionUtil.performActionDumbAware(action, e)
    }
}
