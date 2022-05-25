package com.github.anthonyjclark.idealix

import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener

class LixEditorFactoryListener : EditorFactoryListener {

    override fun editorCreated(event: EditorFactoryEvent) {
        LixState.LOGGER.debug("Lix::editorCreated")
        super.editorCreated(event)

        LixState.editorStates[event.editor] = LixEditorState(event.editor)
    }

    override fun editorReleased(event: EditorFactoryEvent) {
        LixState.LOGGER.debug("Lix::editorReleased")
        super.editorReleased(event)

        LixState.editorStates.remove(event.editor)
    }
}