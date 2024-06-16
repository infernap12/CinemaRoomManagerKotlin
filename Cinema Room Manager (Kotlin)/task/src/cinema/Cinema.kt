package cinema

val room = setup()

fun main() {
//    val room = setup()
    val menu = listOf(null, room::print, ::bookSeat)
    println()
    while (true) {
        printMenu()
        val userInput = readln().toInt()
        println()
        menu[userInput]?.call() ?: break
        println()
    }
}

fun printMenu() {
    println(
        """
    1. Show the seats
    2. Buy a ticket
    0. Exit
    """.trimIndent()
    )
}

fun bookSeat() {
    val seatChoice = askSeat()
    println()
    println("Ticket price: $${room.getSeatPrice(seatChoice.first)}")
    room.bookSeat(seatChoice.first, seatChoice.second)
}

fun askSeat(): Pair<Int, Int> {
    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()
    return Pair(row, seat)
}

private fun printTotalIncome(room: Room) {
    println("Total income:")
    println("$${room.getTotalIncome()}")
}

fun setup(): Room {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    return Room(rows = rows, seats = seats)
}


fun Int.divR(i: Int): Int = this / i + this % i
