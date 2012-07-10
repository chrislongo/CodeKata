import io.Source

/**
 * User: chris
 * Date: 7/8/12
 * Time: 8:41 PM
 */

object WeatherData extends App {
    var minSpread: Int = Int.MaxValue
    var minDay: Int = 0

    for(line <- Source.fromFile("weather.dat").getLines()) {
        val parts = line.trim().split("\\s+")

        if(parts(0).matches("\\d\\d?")) {
            val day: Int = parseInt(parts(0))
            val high: Int = parseInt(parts(1).substring(0, 2))
            val low: Int = parseInt(parts(2).substring(0, 2))
            val spread: Int = high - low
            
            if(spread < minSpread) {
                minSpread = spread
                minDay = day
            }
        }
    }
    
    println(minDay + " " + minSpread)

    def parseInt(s: String) = Integer.parseInt(s, 10)
}
