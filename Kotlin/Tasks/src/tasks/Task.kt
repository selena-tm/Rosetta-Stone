package tasks

class Task (private var name: String) {
    private var completed = false

    fun getName (): String {
        return name
    }

    fun getCompleted (): String {
        if (completed) {
            return "✓"
        }
        return "✗"
    }

    fun changeName (newName: String) {
        name = newName
    }

    fun toggleComplete () {
        completed = !completed
    }
}