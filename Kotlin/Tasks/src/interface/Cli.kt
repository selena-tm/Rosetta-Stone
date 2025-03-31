package `interface`

import io.FileOutput
import io.FileInput
import tasks.Task
import tasks.TaskList

class Cli {
    private var taskList: TaskList = TaskList()

    // simply prints out the options available
    private fun printOptions () {
        println("(l)ist all tasks")
        println("(n)ew task")
        println("(e)dit existing task")
        println("(d)elete task")
        println("(t)oggle task's completeness")
        println("\n")
        println("(c)lose the program")
        println("\n")
        println("enter the letter of your selection: ")
    }

    // get the user's option
    fun getOption () {
        val fileInput = FileInput(taskList)
        fileInput.inputTasks()

        // while the user doesn't enter "c", ask for a new option and evaluate it
        do {
            printOptions()
            val option = readln()
            evaluateOption(option)

        } while (option != "c")

        // when the user enters "c" to close, output tasks to file
        val fileOutput = FileOutput(taskList)
        fileOutput.writeFile()
    }

    // evaluate the option the user entered
    private fun evaluateOption (option: String) {
        when (option) {
            "l" -> listTasks()
            "n" -> newTask()
            "e" -> editTask()
            "d" -> deleteTask()
            "t" -> toggleTask()
            "c" -> println("closing tasks...")
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
        val newTask = Task(name)
        taskList.addTask(newTask)
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

    private fun toggleTask () {
        println("task completion...")
        println("enter the number of the task you wish to toggle complete")
        val number = getNumber()
        val task = taskList.getTask(number)
        task.toggleComplete()
    }

    // make sure the user enters a valid Int
    private fun getNumber (): Int {
        var number: Int?

        do {
            number = readln().toIntOrNull()
        } while (number == null)

        return number
    }
}