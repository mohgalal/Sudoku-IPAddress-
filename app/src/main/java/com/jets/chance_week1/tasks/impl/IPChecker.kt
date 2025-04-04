package com.jets.chance_week1.tasks.impl

fun main() {

    val ip = "192.168.255.256"
    val result = isIPAddressValid(ip)
    println("Is the IP Address Valid? $result")

}

fun isIPAddressValid(ip: String): Boolean {

    val ipSegments = ip.split('.')
    if (ip.isEmpty() || ipSegments.size != 4) return false  //handle empty & more than 3 dots & extra section [1,2,3]

    for (segment in ipSegments) {
        try {
            if (segment.startsWith("0") && segment.length != 1) //123.01.0.11
                return false
            if (segment.toInt() !in 0..255) //handle negative numbers and out of ranges[4,5]
                return false

        } catch (e: NumberFormatException) { //handle input is not numbers & whitespaces[6, 7]
            return false
        }

    }
    return true
}