const val MINUTE = "минуту"
const val MINUTES1 = "минут"
const val MINUTES2 = "минуты"
const val HOUR = "час"
const val HOURS1 = "часа"
const val HOURS2 = "часов"
const val SECONDS: Int = 172800
const val NAME: String = "Иван"

fun main(args: Array<String>) {
    agoToText()
}

fun correctMin(): String {
    val time: String
    val min: Int = SECONDS / 60
    when (true) {
        min % 10 == 1 && min % 100 != 11  -> time = MINUTE
        min % 10 == 0 -> time = MINUTES1
        min % 100 >= 11 && min <= 19 -> time = MINUTES1
        min % 10 >= 2 && min % 10 <= 4 -> time = MINUTES2
        else -> time = MINUTES1
    }
    return time
}
fun correctHour(): String {
    val time: String
    val hour: Int = SECONDS / 3600
    when (true) {
        hour % 10 == 10 -> time = HOUR
        hour % 10 == 0 -> time = HOURS2
        hour % 10 >= 2 && hour % 10 <= 4 -> time = HOURS1
        else -> time = HOURS2
    }
    return time
}
fun agoToText() {
    val min: Int = SECONDS / 60
    val hour: Int = SECONDS / 3600
    when (true) {
        SECONDS >= 0 && SECONDS <= 60 -> println("$NAME был(а) только что")
        SECONDS >= 61 && SECONDS <= 60 * 60 -> println("$NAME был(а) $min ${correctMin()} назад ")
        SECONDS >= 60 * 60 + 1 && SECONDS < 24 * 60 * 60 -> println("$NAME был(а) $hour ${correctHour()} назад ")
        SECONDS >= 24 * 60 * 60 && SECONDS < 24 * 60 * 60 * 2 -> println("$NAME был(а) сегодня")
        SECONDS >= 24 * 60 * 60 * 2 && SECONDS < 24 * 60 * 60 * 3 -> println("$NAME был(а) вчера")
        else -> println("$NAME был(а) давно")
    }
}