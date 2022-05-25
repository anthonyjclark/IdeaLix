package com.github.anthonyjclark.idealix

import com.intellij.ide.DataManager
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.ui.popup.ListPopup
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory
import com.intellij.ui.awt.RelativePoint
import com.intellij.util.Consumer
import java.awt.Point
import java.awt.event.MouseEvent
import javax.swing.Icon
import javax.swing.SwingConstants

class LixStatusBarFactory : StatusBarWidgetFactory {

    override fun getId(): String = LixState.LIX_ID
    override fun getDisplayName(): String = LixState.LIX_DISPLAY_NAME
    override fun isAvailable(project: Project): Boolean = true
    override fun createWidget(project: Project): StatusBarWidget = LixStatusBar()
    override fun disposeWidget(widget: StatusBarWidget) {}
    override fun canBeEnabledOn(statusBar: StatusBar): Boolean = true

    class LixStatusBar : StatusBarWidget, StatusBarWidget.IconPresentation {

        companion object {
            val EnabledIcon = IconLoader.getIcon("/icons/lixEnabled.svg", LixStatusBar::class.java)
            val DisabledIcon = IconLoader.getIcon("/icons/lixDisabled.svg", LixStatusBar::class.java)
        }

        override fun ID(): String = LixState.LIX_ID
        override fun getTooltipText(): String = LixState.LIX_DISPLAY_NAME
        override fun getPresentation(): StatusBarWidget.WidgetPresentation = this
        override fun install(statusBar: StatusBar) {}
        override fun dispose() {}
        override fun getIcon(): Icon = if (LixState.enabled) EnabledIcon else DisabledIcon

        override fun getClickConsumer(): Consumer<MouseEvent>? = Consumer<MouseEvent> { event ->
            val component = event.component
            val popup = LixInfoPopup.getPopup(DataManager.getInstance().getDataContext(component))

            val dimension = popup.content.preferredSize
            val offset = Point(0, -dimension.height)

            popup.show(RelativePoint(component, offset))
        }

        private object LixInfoPopup {

            fun getPopup(dataContext: DataContext): ListPopup {
                val actions = getActions()
                val popup = JBPopupFactory.getInstance().createActionGroupPopup(
                    LixState.LIX_DISPLAY_NAME,
                    actions,
                    dataContext,
                    JBPopupFactory.ActionSelectionAid.SPEEDSEARCH,
                    false,
                    ActionPlaces.POPUP
                )

                popup.setAdText(LixState.LIX_VERSION, SwingConstants.LEFT)
                return popup
            }

            fun getActions(): DefaultActionGroup {
                val actionGroup = DefaultActionGroup()
                actionGroup.isPopup = true

                actionGroup.add(ActionManager.getInstance().getAction("LixToggleAction"))
                actionGroup.addSeparator()

                return actionGroup
            }
        }
    }
}
