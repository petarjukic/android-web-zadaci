
fun main(args: Array<String>) {
    userInput()
}

fun contains(array: Array<Int>, number: Int) = array.contains(number)

fun checkArray(array: Array<Int>, number: Int) {
    var counter: Int = 1

    if(contains(array, number)) {
        println("Potreban je $counter broj za dobiti zeljeni rezultat")
    }
    else {
        counter = count(array, number)
        if(counter == -1) {
            println("Do broja $number nije moguće doći zbrajanjem brojeva iz niza. Rezultat $counter")
        }
        println("Potrebno je $counter brojeva za dobiti zeljeni rezultat")
    }
}

fun largestElement(array: Array<Int>, number: Int, result: Int): Int {
    var max: Int = 0

    for (i in array) {
        if((i < number && i > max) || (result == i && result > 0)) {
            max = i
        }
    }
    return max
}

fun count(array: Array<Int>, number: Int): Int {
    var sum: Int = 0
    var counter: Int = 0
    var result: Int = 0
    var sumRemainder: Int = 0
    var numToForward: Int = number
    var maxNum: Int = 0

    do {
        maxNum = largestElement(array, number, numToForward)
        result = numToForward / maxNum
        counter += result
        sumRemainder = result * maxNum
        sum += sumRemainder
        numToForward = number - sumRemainder

        if(sum > number) {
            return -1
        }
    }while(sum != number)

    return counter
}

fun userInput() {
    println("Unesite velicinu niza: ")
    val arraySize = readLine()!!.toInt()
    println("Unesite clanove niza: ")
    var array = Array<Int>(arraySize) { readLine()!!.toInt() }

    println("Unesite zeljeni broj za provjeru: ")
    val number: Int = readLine()!!.toInt()

    array = array.distinct().toTypedArray()
    checkArray(array, number)
}