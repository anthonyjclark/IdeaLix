package com.github.anthonyjclark.idealix

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.ex.ActionUtil
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbAwareAction
import java.awt.event.KeyEvent

// This single action handles all keyboard interaction when in command mode
class LixEditorKeymapActions(private val editor: Editor) : DumbAwareAction() {

    fun commandMode() {
        registerCustomShortcutSet(LixState.SHORTCUT_SET, editor.contentComponent)
    }

    fun insertMode() {
        unregisterCustomShortcutSet(editor.contentComponent)
        // TODO(ajc): add insert mode keymap
        //registerCustomShortcutSet()
    }

    override fun actionPerformed(e: AnActionEvent) {
        val keyEvent = e.inputEvent as KeyEvent
        val action = LixState.commandKeymap[keyEvent.keyChar] ?: return
        ActionUtil.performActionDumbAware(action, e)
    }
}
