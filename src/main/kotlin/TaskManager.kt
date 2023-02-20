fun main() {
    val mapWithInput = mutableMapOf<Int, String>()
    var i = 1;
    while (true) {
        val input = readln()
        if (input == "") {
            break
        } else {
            mapWithInput[i] = input.trim()
            i++;
        }
    }
    if (mapWithInput.isNotEmpty()) {
        for (str in mapWithInput) println("${str.key}  ${str.value}")
    } else {
        println("No task have been input")
    }

}