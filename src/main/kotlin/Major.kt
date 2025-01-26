package org.example

class Major(val name: String) {
    private val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(courseName: String? = null): Triple<Double, Double, Double> {
        val grades = if (courseName == null) {
            students.map { it.weightedAverage() }
        } else {
            students.flatMap { student ->
                student.courses.filter { it.name == courseName }.map { it.grade }
            }
        }

        val min = grades.minOrNull() ?: 0.0
        val max = grades.maxOrNull() ?: 0.0
        val avg = if (grades.isNotEmpty()) grades.average() else 0.0

        return Triple(min, max, avg)
    }



}