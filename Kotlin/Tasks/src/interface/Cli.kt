package `interface`

import io.FileOutput
import io.FileInput
import tasks.TaskList
import kotlin.system.exitProcess

class Cli {
    private var taskList: TaskList = TaskList()

    private fun printOptions () {
        println("(l)ist all tasks")
        println("(n)ew task")
        println("(e)dit existing task")
        println("(d)elete task")
        println("(m)ark task as complete")
        println("\n")
        println("(c)lose the program")
        println("\n")
        println("enter the letter of your selection: ")
    }

    fun getOption () {
        val fileInput = FileInput(taskList)
        fileInput.inputTasks()

        do {
            printOptions()
            val option = readln()
            evaluateOption(option)
        } while (option != "c")

        val fileOutput = FileOutput(taskList)
        fileOutput.writeFile()
    }

    private fun evaluateOption (option: String) {
        when (option) {
            "l" -> listTasks()
            "n" -> newTask()
            "e" -> editTask()
            "d" -> deleteTask()
            "m" -> completeTask()
            else -> println("invalid option")
        }
    }

    private fun listTasks () {
        println("listing all tasks...")
        println(taskList.getTasks())
    }

    private fun newTask () {
        println("new task creation...")
        println("enter the name of your task")
        val name = readln()
        taskList.addTask(name)
    }

    private fun editTask () {
        println("editing task...")
        println("enter the number of the task you wish to edit")
        val number = getNumber()
        val task = taskList.getTask(number)
        println("enter the new name for the task")
        task.changeName(readln())
    }

    private fun deleteTask () {
        println("task deletion...")
        println("enter the number of the task you wish to delete")
        val number = getNumber()
        taskList.removeTask(number)
    }

    private fun completeTask () {
        println("task completion...")
        println("enter the number of the task you wish to complete")
        val number = getNumber()
        val task = taskList.getTask(number)
        task.completeTask()
    }

    private fun getNumber (): Int {
        var number: Int?

        do {
            number = readln().toIntOrNull()
        } while (number == null)

        return number
    }
}