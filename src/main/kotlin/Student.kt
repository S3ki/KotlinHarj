package org.example

class Student(name : String, age: Int) {
    val courses = mutableListOf<CourseRecord>()

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        val totalCredits = courses.sumOf { it.credits }
        val weightedSum = courses.sumOf { it.grade * it.credits }
        return if (totalCredits > 0) weightedSum / totalCredits else 0.0
    }

    fun weightedAverage(year: Int): Double {
        val coursesInYear = courses.filter { it.yearCompleted == year }
        val totalCredits = coursesInYear.sumOf { it.credits }
        val weightedSum = coursesInYear.sumOf { it.grade * it.credits }
        return if (totalCredits > 0) weightedSum / totalCredits else 0.0
    }

    fun minMaxGrades(): Pair<Double, Double> {
        val grades = courses.map { it.grade }
        return if (grades.isNotEmpty()) grades.minOrNull()!! to grades.maxOrNull()!! else 0.0 to 0.0
    }
}