package cinema

const val FRONT_PRICE = 10
const val BACK_PRICE = 8
const val SMALL_ROOM_SIZE = 60

// Class that represents a distinct room in a cinema
class Room(val rows: Int = 7, val seats: Int = 8) {
    // 2d list of all the seats in the cinema room
    val roomSeats: List<MutableList<Char>> = List(rows) { MutableList(seats) { 'S' } }

    fun print() {
        println("Cinema:")
        print("  ")
        println((1..roomSeats[0].size).joinToString(" "))
        roomSeats.forEachIndexed { i, list ->
            println((i + 1).toString() + " " + list.joinToString(" "))
        }
    }

    // calculate total income based on rows and total seat count
    fun getTotalIncome(): Int {
        return if (rows * seats <= SMALL_ROOM_SIZE) rows * seats * FRONT_PRICE else {
            rows.div(2) * seats * FRONT_PRICE +
                    rows.divR(2) * seats * BACK_PRICE
        }
    }

    fun getSeatPrice(row: Int): Int {
        return if (rows * seats <= SMALL_ROOM_SIZE || row <= this.rows / 2) FRONT_PRICE else BACK_PRICE
    }

    fun bookSeat(row: Int, seat: Int) {
        roomSeats[row - 1][seat - 1] = 'B'
    }
}