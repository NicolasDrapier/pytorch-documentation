package com.nicolasdrapier.pytorchdocumentation

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.jcef.JBCefBrowser
import java.awt.BorderLayout
import javax.swing.JPanel
import kotlin.jvm.internal.Intrinsics

class PytorchDocumentationToolWindowFactory : ToolWindowFactory {
//    @JvmField
//    val icon = IconLoader.getIcon("/META-INF/pluginIcon.svg", javaClass)


    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        Intrinsics.checkNotNullParameter(project, "project")
        Intrinsics.checkNotNullParameter(toolWindow, "toolWindow")
        val webViewPanel = JPanel(BorderLayout())
        val jbcefBrowser = JBCefBrowser()
        jbcefBrowser.loadURL("https://pytorch.org/docs/stable/index.html")
        webViewPanel.add(jbcefBrowser.component, "Center")
        val contentFactory = ContentFactory.getInstance()
        Intrinsics.checkNotNullExpressionValue(
            contentFactory.createContent(webViewPanel, "", false),
            "contentFactory.createCon\"\", false)"
        )
        val content = contentFactory.createContent(webViewPanel, "", false)
        toolWindow.contentManager.addContent(content)
    }

//    override fun init(toolWindow: ToolWindow) {
//        toolWindow.setIcon(icon)
//    }
}

