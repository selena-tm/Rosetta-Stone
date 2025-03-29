package io

import tasks.TaskList
import java.io.File

class FileInput (private var taskList: TaskList) {

    private fun readTasksFromFile(): List<String> {
        return File("tasks.txt").bufferedReader().readLines().dropLast(0)
    }

    fun inputTasks () {
        val lines = readTasksFromFile()

        for (line in lines) {
            //println("line $line \n")
            val task = line.split(". ")
            taskList.addTask(task[1])
        }
    }
}