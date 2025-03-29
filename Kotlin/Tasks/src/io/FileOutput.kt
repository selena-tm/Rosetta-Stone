package io

import tasks.TaskList
import java.io.File

class FileOutput (private var taskList: TaskList) {

    fun writeFile () =
        File("tasks.txt").printWriter().use { out -> out.println(taskList.getTasks()) }
}