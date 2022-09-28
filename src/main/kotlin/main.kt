fun main() {

    val result = calcSumPayment(25000, typePayment = "Visa/Mir")
    println(result)
}

fun calcSumPayment (sumPayment: Int, sumMonthPayment: Int = 0, typePayment: String = "VK Pay"): Int {
    val totalTax = (taxPayment(typePayment) * sumPayment).toInt()
    return when(typePayment) {
        "Visa/Mir" -> if (totalTax < 35) 35 else totalTax
        "Maestro/MasterCard" -> if ((sumMonthPayment + sumPayment) >75000) totalTax + 20 else 0
        else -> 0
    }
}

fun taxPayment (typePayment: String) = when (typePayment) {
        "Visa/Mir" -> 0.0075
        "Maestro/MasterCard" -> 0.006
        else -> 0.0
}

