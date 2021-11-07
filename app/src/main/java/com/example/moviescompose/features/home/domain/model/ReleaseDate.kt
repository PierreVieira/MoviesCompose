package com.example.moviescompose.features.home.domain.model

data class ReleaseDate(
    val day: Int,
    val month: Int,
    val year: Int
) {
    override fun toString() = "$day de ${toStringMonth(month)} de $year"

    @Throws(IllegalArgumentException::class)
    private fun toStringMonth(month: Int): String {
        if (month < 1 || month > 12) {
            throw IllegalArgumentException("The month must be in the inclusive range between 1 and 12")
        }
        val months = listOf(
            "jan",
            "fev",
            "mar",
            "abr",
            "mai",
            "jun",
            "jul",
            "ago",
            "set",
            "out",
            "nov",
            "dez"
        )
        return months[month - 1]
    }
}
