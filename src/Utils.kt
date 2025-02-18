object Utils {
    fun clearConsole() {
//        print("\u001b[H\u001b[2J")
//        System.out.flush()

//        ProcessBuilder("clear").inheritIO().start().waitFor()

        repeat(10) { println() }
    }

    fun isAlpha(s: String): Boolean = s.all { it.isLetter()}

    fun isNumeric(s: String): Boolean = s.all { it.isDigit() }
}