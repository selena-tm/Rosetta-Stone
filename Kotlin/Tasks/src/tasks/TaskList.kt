package tasks

class TaskList {
    private var tasks: MutableList<Task> = mutableListOf()

    fun addTask (name: String) {
        val task = Task(name)
        tasks.add(task)
    }

    fun getTask (number: Int): Task {
        return tasks[number - 1]
    }

    fun removeTask (number: Int) {
        tasks.removeAt(number - 1)
    }

    fun getTasks (): String {
        val taskString: StringBuilder = StringBuilder()

        for (task in tasks.withIndex()) {
            taskString.append("${task.index + 1}. ${task.value.getName()}\n ${task.value.getCompleted()}\n")
        }

        return taskString.toString()
    }


}
