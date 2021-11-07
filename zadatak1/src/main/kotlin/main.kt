import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {
    chooseRounds()
}

fun chooseRounds() {
    println("Unesite broj rundi za igrat: ")
    val numberOfRounds = readLine()!!.toInt()

    game(numberOfRounds)
}

fun computer(array: Array<String>) = array[Random(System.nanoTime()).nextInt(0, 3)]

fun checkResult(array: Array<String>, userSelect: String, score: Array<Int>): Array<Int> {
    val computerSelect: String = computer(array)
    println("Odabir racunala $computerSelect")
    val win = listOf("kamen skare", "skare papir", "papir kamen")
    val lost = listOf("papir skare", "skare kamen", "kamen papir")
    val result: String = "$userSelect $computerSelect"

    if(win.contains(result)) {
        score[0] += 1
    }
    else if(lost.contains(result)) {
        score[1] += 1
    }
    return score
}

fun checkWinner(score: Array<Int>) {
    when {
        score[0] > score[1] -> {
            println("Igrac je pobjednik s ${score[0]} bodova")
        }
        score[0] < score[1] -> {
            println("Racunalo je pobjednik s ${score[1]} bodova")
        }
        else -> {
            println("Rezultat je izjednacen")
        }
    }
}

fun game(numberOfRounds: Int) {
    val array = arrayOf<String>("kamen", "skare", "papir")
    var userSelect: String
    var counter: Int = numberOfRounds
    var score = arrayOf<Int>(0 ,0)


    while (counter > 0) {
        println("Unesite kamen, skare ili papir")
        userSelect = readLine().toString().toLowerCase()

        if(Arrays.stream(array).anyMatch { t -> t == userSelect }) {
            counter -= 1
            score = checkResult(array, userSelect, score)
        }
        else {
            println("Krivi odabir")
        }
    }
    checkWinner(score)
}