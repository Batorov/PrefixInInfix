fun isNumber(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }
    for (symbol in s) {
        if (!symbol.isDigit()) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    val ops = arrayOf("+", "-", "*", "/")

    print("Please enter prefix expression = ")
    val answer: String? = readLine()

    val parts = answer?.split(' ')?.reversed()


    val stack = mutableListOf<String>()

    if (!parts.isNullOrEmpty()) {
        for (part in parts) {
            if (part in ops) {
                if (stack.size > 1) {
                    val op1 = stack.removeAt(stack.lastIndex)
                    val op2 = stack.removeAt(stack.lastIndex)
                    when (part) {
                        "+" -> stack.add("(" + op1 + " + " + op2 + ")")
                        "-" -> stack.add("(" + op1 + " - " + op2 + ")")
                        "/" -> stack.add("(" + op1 + " / " + op2 + ")")
                        "*" -> stack.add("(" + op1 + " * " + op2 + ")")
                    }
                }
                else {
                    println("wrong expression!")
                    break
                }
            }
            else {
                if (isNumber(part)) {
                    stack.add(part)
                }
                else {
                    println("Wrong expression")
                    break
                }
            }
        }
    }

    if (stack.isEmpty()) {
        println("wrong expression!")
    } else if (stack.size > 1) {
        println("wrong expression!")
    } else {
        println("Infix expression = ${stack.removeAt(stack.lastIndex)}")
    }
}