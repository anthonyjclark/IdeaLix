package com.github.anthonyjclark.idealix

import com.github.anthonyjclark.idealix.action.LixInsertModeAction
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.IdeActions
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.extensions.PluginId
import java.awt.event.KeyEvent

object LixState {

    // ----------------------------------------------------------------
    //   ____                _              _
    //  / ___|___  _ __  ___| |_ __ _ _ __ | |_ ___
    // | |   / _ \| '_ \/ __| __/ _` | '_ \| __/ __|
    // | |__| (_) | | | \__ \ || (_| | | | | |_\__ \
    //  \____\___/|_| |_|___/\__\__,_|_| |_|\__|___/
    // ----------------------------------------------------------------

    const val LIX_ID: String = "com.github.anthonyjclark.idealix"
    const val LIX_DISPLAY_NAME: String = "IdeaLix"
    val LIX_VERSION: String? = PluginManagerCore.getPlugin(PluginId.getId(LIX_ID))?.version
    val LOGGER: Logger = logger<LixState>()

    // ----------------------------------------------------------------
    //  __  __       _        _     _        ____  _        _
    // |  \/  |_   _| |_ __ _| |__ | | ___  / ___|| |_ __ _| |_ ___
    // | |\/| | | | | __/ _` | '_ \| |/ _ \ \___ \| __/ _` | __/ _ \
    // | |  | | |_| | || (_| | |_) | |  __/  ___) | || (_| | ||  __/
    // |_|  |_|\__,_|\__\__,_|_.__/|_|\___| |____/ \__\__,_|\__\___|
    // ----------------------------------------------------------------

    var enabled: Boolean = true
    var editorStates: HashMap<Editor, LixEditorState> = HashMap()
    var commandKeymap: Map<Int, AnAction>

    private val actionManager = ActionManager.getInstance()

    init {
        // TODO(ajc): load from file
        // KeyStroke.getKeyStroke('w').keyCode
        commandKeymap = mapOf(
            KeyEvent.VK_I to LixInsertModeAction(),
            KeyEvent.VK_H to actionManager.getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_LEFT),
            KeyEvent.VK_J to actionManager.getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_DOWN),
            KeyEvent.VK_K to actionManager.getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_UP),
            KeyEvent.VK_L to actionManager.getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_RIGHT),
        )
    }
}