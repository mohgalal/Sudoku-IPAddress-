package com.jets.chance_week1.tasks.test

import com.jets.chance_week1.tasks.impl.isIPAddressValid

fun main() {
    testIPAddress(
        name = "Given a valid IP address, When validated, Then it should return true",
        result = isIPAddressValid("192.168.1.1"),
        correctResult = true
    )

    testIPAddress(
        name = "Given an empty IP address, When validated, Then it should return false",
        result = isIPAddressValid(""),
        correctResult = false
    )

    testIPAddress(
        name = "Given an IP address with only 3 segments, When validated, Then it should return false",
        result = isIPAddressValid("192.168.1"),
        correctResult = false
    )

    testIPAddress(
        name = "Given an IP address with a segment > 255, When validated, Then it should return false",
        result = isIPAddressValid("392.168.1.1"),
        correctResult = false
    )

    testIPAddress(
        name = "Given an IP address with 5 segments, When validated, Then it should return false",
        result = isIPAddressValid("192.168.1.1.2"),
        correctResult = false
    )

    testIPAddress(
        name = "Given an IP address with leading zeros, When validated, Then it should return false",
        result = isIPAddressValid("192.001.01.1"),
        correctResult = false
    )

    testIPAddress(
        name = "Given an IP address with consecutive dots, When validated, Then it should return false",
        result = isIPAddressValid("192.168..1.1"),
        correctResult = false
    )

    testIPAddress(
        name = "Given a non-numeric IP address, When validated, Then it should return false",
        result = isIPAddressValid("hundred.nine.zero.five"),
        correctResult = false
    )

    testIPAddress(
        name = "Given an all-zero IP address, When validated, Then it should return true",
        result = isIPAddressValid("0.0.0.0"),
        correctResult = true
    )

    testIPAddress(
        name = "Given an all-255 IP address, When validated, Then it should return true",
        result = isIPAddressValid("255.255.255.255"),
        correctResult = true
    )

    testIPAddress(
        name = "Given an IP address with a negative segment, When validated, Then it should return false",
        result = isIPAddressValid("192.-168.1.1"),
        correctResult = false
    )

    testIPAddress(
        name = "Given an IP address with spaces, When validated, Then it should return false",
        result = isIPAddressValid("192. 168.1.1"),
        correctResult = false
    )

}

fun testIPAddress(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult)
        println("Success - $name")
    else
        println("Fail - $name")
}