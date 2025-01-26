package org.example

fun main() {

    val human = Human("Mike", 2)
    human.getOlder()

    println(human.age)
}

fun displayAlertMessage(operatingSystem: String, emailId: String) {
    println("There's a new sign-in request on $operatingSystem for your Google Account $emailId.\n")
}