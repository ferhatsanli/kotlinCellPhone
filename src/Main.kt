fun main() {
    val yellowPages = ArrayList<Person>()
    yellowPages.add(Person("ferhat", "13"))
    Utils.clearConsole()
    CellPhone.menuMain()
    while (true) {
        when (CellPhone.readChoose()) {
            1 -> CellPhone.menuList(yellowPages)
            2 -> CellPhone.menuAdd(yellowPages)
            3 -> CellPhone.menuUpdate(yellowPages)
            4 -> CellPhone.menuDelete(yellowPages)
            5 -> CellPhone.changeLang()
            6 -> return
        }
    }
}

