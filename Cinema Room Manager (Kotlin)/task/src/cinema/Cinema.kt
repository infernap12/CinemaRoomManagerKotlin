package cinema

val room = setup()

fun main() {
//    val room = setup()
    val menu = listOf(null, room::print, ::bookSeat, ::statistics)
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
    3. Statistics
    0. Exit
    """.trimIndent()
    )
}

fun bookSeat() {
    while (true) {
        val (row, seat) = askSeat()
        println()
        if (row !in 1..room.rows || seat !in 1..room.seats){
            println("Wrong input!\n")
            continue
        }

        if (room.get(row, seat) == 'B') {
            println("That ticket has already been purchased!")
            continue
        }
        println("Ticket price: $${room.getSeatPrice(row)}")
        room.bookSeat(row, seat)
        return
    }
}

fun askSeat(): Pair<Int, Int> {
    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()
    return Pair(row, seat)
}

fun statistics() {
    println(
        """
        Number of purchased tickets: ${room.purchased}
        Percentage: ${"%.2f%%".format(room.capacity)}
        Current income: $${room.getCurrentIncome()}
        Total income: $${room.getTotalIncome()}
        """.trimIndent()
    )
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
