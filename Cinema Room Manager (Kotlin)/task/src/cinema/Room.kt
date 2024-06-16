package cinema

const val FRONT_PRICE = 10
const val BACK_PRICE = 8
const val SMALL_ROOM_SIZE = 60

// Class that represents a distinct room in a cinema
class Room(val rows: Int = 7, val seats: Int = 8) {
    val map: List<MutableList<Char>> = List(rows) { MutableList(seats) { 'S' } }

    fun print() {
        println("Cinema:")
        print("  ")
        println((1..map[0].size).joinToString(" "))
        map.forEachIndexed { i, list ->
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
}