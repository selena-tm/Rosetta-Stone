package tasks

class TaskList {
    private var tasks: MutableList<Task> = mutableListOf()

    fun addTask (task: Task) {
        tasks.add(task)
    }

    fun getTask (number: Int): Task {
        return tasks[number - 1]
    }

    fun removeTask (number: Int) {
        tasks.removeAt(number - 1)
    }

    // returns a string representation of the tasks contained in the list
    fun getTasks (): String {
        val taskString: StringBuilder = StringBuilder()

        for (task in tasks.withIndex()) {
            taskString.append("${task.index + 1}. ${task.value.getName()} ${task.value.getCompleted()}\n")
        }

        return taskString.toString()
    }


}
