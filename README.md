# IdeaLix

![Build](https://github.com/anthonyjclark/IdeaLix/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Coding ToDo

- popup link to settings (XDG)
- popup link to GitHub
- popup link to IDE settings (key conflicts?)

### Long-term

- keymap conflicts
- update icon on toggle (need listener?)
- light edit mode
- macros
- marks
- how to test?
- window border for mode (maybe cursor is good enough)
- kak/vim/insert modes?
- use JB macros
- list of all actions: https://centic9.github.io/IntelliJ-Action-IDs/
- dynamic plugin (load without restarting)

- https://github.com/helix-editor/helix/discussions/2172
- https://github.com/helix-editor/helix/discussions/2432

## Notes

- many ways to handle key presses
- probably best to go with `DumbAwareAction`s instead of `Keymap`s

## Keymap Thoughts

- object -> verb
- text objects first priority
- jumping: type as much as you want hit enter, cycle
  - case-insensitive but not fuzzy
- less focus on movement by character
- helix config format
- put paired actions next to one another (e.g., word/back, undo/redo)
- pinky key hold modifiers?
- insertion mode modifier to execute commands? (e.g., Alt-J for J) vs crtl-o
- https://github.com/machakann/vim-sandwich
- use capitals for immediate actions not acting on selection


- selection actions (action selects some text)
  - word, Word, PartialWord, sentence, quotes, paragraph, block, function, class
  - find, till, beginning of line, end of line, first character of line
  - modifiers: inner/around/next/previous/... 
- command actions (action operates on selection or ignores selection)
  - copy, paste, delete, undo, redo
  - format, comment, change case, join, increment/decrement, rename
  - repeat, macros, run shell command
  - jump, search, next/previous, jump to tag
  - multiple cursors: by line, search in selection, align cursors
  - insert: at cursor, after, above, below, beginning, end
  - screen motion: half page up/down, quarter page up/down, center
  - switch editor tab
  - open helpers (ctrl enter, option enter, shift shift, etc.)
  - save, open file, find in files
  - Note: some can be found under leader
- shortcuts
  - [command] till end of line (like vim D, C, and Y)
- other
  - find and replace
  - build
  - debugging



- JetBrains shortcuts
  - search everywhere (shift shift)
  - find action (shift cmd a)
  - intention actions (opt enter)
  - navigate code issues (F2 and shift F2)
  - recent files (cmd E)
  - complete statement (shift cmd enter)
  - reformat code (opt cmd L)
  - invoke refactoring (ctrl T)
  - extend/shrink selection (opt up/down)
  - go to declaration (cmd B)
  - find usages (opt F7)
  - project window (cmd 1)
  - version control (ctrl V)
  - code completion (ctrl space)
  - run anything (ctrl ctrl)
- Xah Fly Keys
  - unsplit and split (3 and 4)
  - delete forward (5)
  - select paragraph/line/word/quote (6/7/8/9)
  - special move to beginning of line then indent then paragraph
  - beginning of buffer (space h)
  - end of buffer (space n)
  - delete word left right (e and r)
  - jump to matching bracket
  - delete block of text
  - delete blank line
  - delete to end of line (space g)
  - copy/cut all or region (space c/x)
  - 



## Resources

- https://jetbrains.design/intellij/

- [IdeaVim](https://github.com/JetBrains/ideavim/)
- [ErgoKeys](https://github.com/amibiz/ergo-keys/)
  - extensions
    - applicationConfigurable
    - applicationService
  - application-component
  - extensions
    - bundledKeymap
  - actions
    - action (several; some with keyboard-shortcut)
  - code
    - EditorFactoryListener
    - KeymapManagerListener
- [AceJump](https://github.com/acejump/AceJump)
  - extensions
    - applicationService
    - applicationConfigurable
    - editorActionHandler (several)
  - application-component
  - actions
    - action (several; some with keyboard-shortcut)
  - code
    - manage sessions (maybe for each editor?)
    - TypedActionHandler
    - EditorActionHandler
- [SexyScroll](https://github.com/huoguangjin/SexyMove/)
  - notes
    - No special keys
  - extensions
    - applicationService
    - applicationConfigurable
  - actions
    - action (several; some with keyboard-shortcut)
  - code
    - EditorFactoryListener
    - EditorActionHandler inside InactiveEditorAction
    - EditorActionHandler

- https://github.com/ibhagwan/vim-cheatsheet
- https://learnvimscriptthehardway.stevelosh.com/chapters/04.html

- https://github.com/mawww/kakoune#3-basic-interaction
- https://docs.helix-editor.com/keymap.html
- https://github.com/helix-editor/helix/discussions/1446
- https://vamolessa.github.io/pepper/pepper/rc/bindings

- http://xahlee.info/emacs/misc/xah-fly-keys_tutorial.html

## Template ToDo list

- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Get familiar with the [template documentation][template].
- [x] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections. 
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "IdeaLix"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/anthonyjclark/IdeaLix/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
