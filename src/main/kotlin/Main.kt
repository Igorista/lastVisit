fun main(args: Array<String>) {
    val name: String = "Иван"
    val time: Int = 1800
    println("$name ${agoToText(time)}")
}

fun correctMin(seconds: Int): String {
    val time: String
    val min: Int = seconds / 60
    when {
        min % 10 == 1 && min % 100 != 11 -> time = "минуту"
        min % 10 == 0 -> time = "минут"
        min % 100 >= 11 && min <= 19 -> time = "минут"
        min % 10 in 2..4 -> time = "минуты"
        else -> time = "минут"
    }
    return time
}

fun correctHour(seconds: Int): String {
    val time: String
    val hour: Int = seconds / 3600
    when {
        hour % 10 == 10 -> time = "час"
        hour % 10 == 0 -> time = "часов"
        hour % 10 in 2..4 -> time = "часа"
        else -> time = "часов"
    }
    return time
}

fun agoToText(seconds: Int): String {
    val min: Int = seconds / 60
    val hour: Int = seconds / 3600
    val visit: String =
        when {
            seconds in 0..60 -> "был(а) только что"
            seconds >= 61 && seconds <= 60 * 60 -> "был(а) $min ${correctMin(seconds)} назад "
            seconds >= 60 * 60 + 1 && seconds < 24 * 60 * 60 -> "был(а) $hour ${correctHour(seconds)} назад "
            seconds >= 24 * 60 * 60 && seconds < 24 * 60 * 60 * 2 -> "был(а) сегодня"
            seconds >= 24 * 60 * 60 * 2 && seconds < 24 * 60 * 60 * 3 -> "был(а) вчера"
            else -> "был(а) давно"
        }
    return visit

}