package com.github.anthonyjclark.idealix.services

import com.intellij.openapi.project.Project
import com.github.anthonyjclark.idealix.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
