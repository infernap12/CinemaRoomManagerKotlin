package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val room = Room(rows = rows, seats = seats)
    println("Total income:")
    room.getTotalIncome()

}
