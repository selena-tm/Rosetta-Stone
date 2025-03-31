package io

import tasks.Task
import tasks.TaskList
import java.io.File

class FileInput (private var taskList: TaskList) {

    // get all lines of file
    private fun readTasksFromFile(): List<String> {
        return File("tasks.txt").bufferedReader().readLines()
    }

    fun inputTasks () {
        val lines = readTasksFromFile()

        // loop through lines, input a task for each nonempty line
        for (line in lines) {
            if (line.isNotEmpty()) {

                val task = line.split(" ")
                val newTask = Task(task[1])

                // mark if the task is complete or not
                if (task[2] == "✓") {
                    newTask.toggleComplete()
                }
                taskList.addTask(newTask)
            }
        }
    }
}