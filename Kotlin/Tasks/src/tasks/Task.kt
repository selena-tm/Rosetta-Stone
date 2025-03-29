package tasks

class Task (private var name: String) {
    private var completed = false

    fun getName (): String {
        return name
    }

    fun getCompleted (): Boolean {
        return completed
    }

    fun changeName (newName: String) {
        name = newName
    }

    fun completeTask () {
        completed = true
    }
}