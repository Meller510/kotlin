class Stack<T>() {
    private val stack = arrayListOf<T>()

    fun push(item: T) = stack.add(item)

    fun pop(): T? {
        val item = stack.lastOrNull()
        if (!isEmpty()) {
            stack.removeAt(stack.size - 1)
        }
        return item
    }

    fun size(): Int = stack.size

    fun isEmpty(): Boolean = stack.isEmpty()
}