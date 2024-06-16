package cinema

// Class that represents a distinct room in a cinema
class Room(val rows: Int = 7, val seats: Int = 8) {
    val map: List<MutableList<Char>> = List(rows) { MutableList(seats) { 'S' } }

    fun print(): Unit {
        println("Cinema:")
        print("  ")
        println((1..map[0].size).joinToString(" "))
        map.forEachIndexed { i, list ->
            println((i + 1).toString() + " " + list.joinToString(" "))
        }
    }
    // calculate total income based on rows and total seat count
    fun getTotalIncome() {
        TODO("Not yet implemented")
    }
}