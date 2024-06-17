package cinema

const val FRONT_PRICE = 10
const val BACK_PRICE = 8
const val SMALL_ROOM_SIZE = 60

// Class that represents a distinct room in a cinema
class Room(val rows: Int = 7, val seats: Int = 8) {
    // 2d list of all the seats in the cinema room
    val roomSeats: List<MutableList<Char>> = List(rows) { MutableList(seats) { 'S' } }
    val small = rows * seats <= SMALL_ROOM_SIZE
    val purchased: Int get() = countPurchasedSeats(roomSeats)
    val capacity: Double get() = purchased.toDouble() / (rows * seats) * 100
    val frontRows get() = roomSeats.take(rows.div(2))
    val backRows get() = roomSeats.takeLast(rows.divR(2))

    fun print() {
        println("Cinema:")
        print("  ")
        println((1..roomSeats[0].size).joinToString(" "))
        roomSeats.forEachIndexed { i, list ->
            println((i + 1).toString() + " " + list.joinToString(" "))
        }
    }

    fun get(row: Int, seat: Int): Char {
        return roomSeats[row - 1][seat - 1]
    }

    // calculate total income based on rows and total seat count
    fun getTotalIncome(): Int {
        return if (small) rows * seats * FRONT_PRICE else {
            rows.div(2) * seats * FRONT_PRICE +
                    rows.divR(2) * seats * BACK_PRICE
        }
    }

    fun getSeatPrice(row: Int): Int {
        return if (small || row <= this.rows / 2) FRONT_PRICE else BACK_PRICE
    }

    fun bookSeat(row: Int, seat: Int) {
        roomSeats[row - 1][seat - 1] = 'B'
    }

    fun getCurrentIncome(): Int {
        return if (small) purchased * FRONT_PRICE else {
            countPurchasedSeats(frontRows) * FRONT_PRICE + countPurchasedSeats(backRows) * BACK_PRICE
        }
    }

    private fun countPurchasedSeats(rows: List<List<Char>>): Int = rows.flatten().count { it == 'B' }
}