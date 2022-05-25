package com.github.anthonyjclark.idealix

import com.intellij.openapi.editor.Editor

class LixEditorState(editor: Editor) {

    enum class LixEditorMode {
        Command,
        Insert
    }

    var mode: LixEditorMode = LixEditorMode.Command

    //    var keymap: LixKeymap = LixKeymap()
    var keymap: LixEditorKeymapActions = LixEditorKeymapActions(editor)

    fun commandMode() {
        mode = LixEditorMode.Command
        keymap.commandMode()
    }

    fun insertMode() {
        mode = LixEditorMode.Insert
        keymap.insertMode()
    }

}
