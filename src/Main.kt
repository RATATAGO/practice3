import kotlin.random.Random

fun main() {

    gameGuessNumber();
}

/// made by Andrew
private fun gameGuessNumber() {
    var isComputerQueue: Boolean = false;

    while (true) {
        if(isComputerQueue){
            guessPlayer();
            isComputerQueue=!isComputerQueue
        }
        else {
            guessComputer()
            isComputerQueue=!isComputerQueue
        }

    }

}

private fun guessComputer() {
    var playerNumber: Int = 0
    var lowerBound = 1
    var upperBound = 100
    var computerNumber: Int = 0
    println("Гравець загадує число :")
    val player1Input = readlnOrNull()
    playerNumber = player1Input?.toIntOrNull() ?: -1
    if(playerNumber==-1)
    {
        println("Помилка! Ви ввели не корректне число")
        return
    }
    do {
        computerNumber = Random.nextInt(lowerBound, upperBound + 1)
        println("Комп'ютер думає, що це: $computerNumber")
        if(computerNumber==playerNumber)
        {
            println("Компютер вгадав :)")
            return
        }

        println("Якщо число більше, введіть +, якщо менше, введіть '-'")
        val userInput = readlnOrNull()

        when (userInput) {
            "+" -> lowerBound = computerNumber + 1
            "-" -> upperBound = computerNumber - 1
            else -> println("Будь ласка, введіть '+', '-'")
        }
        if (lowerBound > upperBound) {
            println("помилка в підсказках!")
            return
        }
    } while (true)
}

private fun guessPlayer() {
    var playerNumber: Int = 0
    var computerNumber: Int = 0
    println("Компютер загадє число")
    computerNumber = Random.nextInt(0,100+1);
    while (true){
        println("Вгадайте число:")
        val player1Input = readlnOrNull()
        playerNumber = player1Input?.toIntOrNull() ?: -1
        if(playerNumber==-1)
        {
            println("Введіть коректне число")
            continue
        }
        if(playerNumber==computerNumber){
            println("Ого! Ви Відгадали!")
            return
        }

        if(playerNumber<computerNumber)
        {
            println("Число більше")

        }else{
            println("Число менше")
        }

    }
}