fun main(args: Array<String>) {
    println("Unesite rijec ili  recenicu za provjeru palindroma: ")
    val userInput: String? = readLine()?.toLowerCase()

    if (userInput != null) {
        checkPalindrome(userInput)
    }
    else {
        checkPalindrome("ana")
    }
}

fun multipleWordsPalindrome(userInput: String, reversedString: String): String {
    val nonAlphaNum = "[^a-zA-Z0-9]".toRegex()
    val oneString: String = userInput.replace(nonAlphaNum, "")
    val reversedOneString: String = reversedString.replace(nonAlphaNum, "")

    if(oneString == reversedOneString) {
        return "Palindrom"
    }
    return "Nije palindrom"
}

fun singleWordPalindrome(userInput: String, reversedString: String): String {
    if(userInput == reversedString){
        return "Palindrom"
    }
    return "Nije palindrom"
}

fun countWords(userInput: String): Int {
    val strArray = userInput.split(" ".toRegex()).toTypedArray()
    var count: Int = 0

    for (word in strArray) {
        if(word != "") {
            count++
        }
    }
    return count
}

fun checkPalindrome(userInput: String) {
    val reversedString: String = userInput.reversed()

    if(countWords(reversedString) == 1) {
        println(singleWordPalindrome(userInput, reversedString))
    }
    else {
        println(multipleWordsPalindrome(userInput, reversedString))
    }
}
