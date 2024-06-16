package cinema

fun main() {
    val room = setup()
    println()
    room.print()
    println()
    bookSeat(room)
}

fun bookSeat(room: Room) {
    val seatChoice = askSeat()
    println()
    println("Ticket price: $${room.getSeatPrice(seatChoice.first)}")
    room.bookSeat(seatChoice.first, seatChoice.second)
    println()
    room.print()
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
