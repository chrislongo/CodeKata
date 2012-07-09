import io.Source

/**
 * User: chris
 * Date: 7/8/12
 * Time: 10:00 PM
 */

object FootballData extends App {
    var minSpread: Int = Int.MaxValue
    var minTeam: String = null

    for (line <- Source.fromFile("football.dat").getLines()) {
        val parts = line.trim().split("\\s+")

        if (parts(0).matches("\\d\\d?.?")) {
            val team = parts(1)
            val f: Int = parseInt(parts(6).substring(0, 2))
            val a: Int = parseInt(parts(8).substring(0, 2))
            val spread: Int = max(f, a) - min(f, a)

            if (spread < minSpread) {
                minSpread = spread
                minTeam = team
            }
        }
    }

    println(minTeam + " " + minSpread)

    def parseInt(s: String) = Integer.parseInt(s, 10)
    def max(a: Int, b: Int): Int = if(a > b) a else b
    def min(a: Int, b: Int): Int = if(a < b) a else b
}
