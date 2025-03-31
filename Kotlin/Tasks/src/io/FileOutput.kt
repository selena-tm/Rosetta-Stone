package io

import tasks.TaskList
import java.io.File

class FileOutput (private var taskList: TaskList) {

    // writes out the task list to file
    fun writeFile () =
        File("tasks.txt").printWriter().use { out -> out.print(taskList.getTasks()) }
}