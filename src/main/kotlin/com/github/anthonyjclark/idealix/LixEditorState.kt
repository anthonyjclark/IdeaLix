package com.github.anthonyjclark.idealix

import com.intellij.openapi.editor.Editor

class LixEditorState(private val editor: Editor) {

    enum class LixEditorMode {
        Command,
        Insert
    }

    var mode: LixEditorMode = LixEditorMode.Command
    var keymap: LixEditorKeymapActions = LixEditorKeymapActions(editor)

    init {
        commandMode()
    }

    fun commandMode() {
        editor.settings.isBlockCursor = true
        mode = LixEditorMode.Command
        keymap.commandMode()
    }

    fun insertMode() {
        editor.settings.isBlockCursor = false
        /**/mode = LixEditorMode.Insert
        keymap.insertMode()
    }

}
