package com.github.anthonyjclark.idealix

import com.github.anthonyjclark.idealix.action.LixInsertModeAction
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.fileEditor.FileDocumentManager
import java.io.File
import javax.swing.KeyStroke

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

    // TODO(ajc): use XDG_CONFIG_HOME
    const val LIX_CONFIG_FILEPATH = "/idealix.txt"

    private const val LOWER_LETTERS = "abcdefghijklmnopqrstuvwxyz"
    private const val UPPER_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private const val NUMBERS = "0123456789"
    private const val PUNCTUATION = "`!@#$%^&*()_+~-=[]\\{}|;':\",./<>?"

    private const val TYPED_KEYS = LOWER_LETTERS + UPPER_LETTERS + NUMBERS + PUNCTUATION
    private val ALL_HANDLED_TYPED_KEYS = TYPED_KEYS.map { KeyStroke.getKeyStroke(it) }
    private val ALL_KEYBOARD_SHORTCUTS = ALL_HANDLED_TYPED_KEYS.map { KeyboardShortcut(it, null) }
    val SHORTCUT_SET = CustomShortcutSet(*ALL_KEYBOARD_SHORTCUTS.toTypedArray())
    // TODO(ajc): two-key shortcuts?

    // ----------------------------------------------------------------
    //  __  __       _        _     _        ____  _        _
    // |  \/  |_   _| |_ __ _| |__ | | ___  / ___|| |_ __ _| |_ ___
    // | |\/| | | | | __/ _` | '_ \| |/ _ \ \___ \| __/ _` | __/ _ \
    // | |  | | |_| | || (_| | |_) | |  __/  ___) | || (_| | ||  __/
    // |_|  |_|\__,_|\__\__,_|_.__/|_|\___| |____/ \__\__,_|\__\___|
    // ----------------------------------------------------------------

    var enabled: Boolean = true
    var editorStates: HashMap<Editor, LixEditorState> = HashMap()

    // TODO(ajc): two-key shortcuts? (Char, Char)
    var commandKeymap: Map<Char, AnAction>


    init {
        val actionManager = ActionManager.getInstance()

        // TODO(ajc): load from file


        commandKeymap = mapOf(
            'i' to LixInsertModeAction(),
            'h' to actionManager.getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_LEFT),
            'j' to actionManager.getAction(IdeActions.ACTIONEDISELECT),
            'k' to actionManager.getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_UP),
            'l' to actionManager.getAction(IdeActions.ACTION_EDITOR_MOVE_CARET_RIGHT),
        )
    }
}