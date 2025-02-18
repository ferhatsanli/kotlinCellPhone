class CellPhone {
    companion object {
        private var texts: Language = LangEng()

        fun menuMain() {
            println(texts.mainMenu)
        }

        private fun startOver(){
            println(texts.pressKey)
            readln()
            Utils.clearConsole()
            menuMain()
        }

        fun readChoose(): Int {
            print(">>")
            val response: String = readln()
            if (response == "") return 0
            return when (Utils.isNumeric(response)) {
                true -> response.toInt()
                false -> 0
            }
        }

        fun menuList(yellowPages: ArrayList<Person>) {
            println("${texts.name}\t${texts.number}")
            for (rec in yellowPages) {
                println("${rec.name}:\t${rec.number}")
            }
            startOver()
        }

        fun menuAdd(yellowPages: ArrayList<Person>) {
            var name: String = ""
            var number: String = ""

            println(texts.titleMAdd)
            do{
                do {
                    print("${texts.name}: ")
                    name = readln()
                } while (name.isEmpty())
                do {
                    print("${texts.number}: ")
                    number = readln()
                } while (number.isEmpty())

            } while (recExists(Person(name, number), yellowPages))
            yellowPages.add(Person(name, number))
            startOver()
        }

        fun menuUpdate(yellowPages: ArrayList<Person>) {
            var phrase = ""
            var iFound: Int = -1

            println(texts.titleMUpdate)
            print("${texts.find}: ")
            phrase = readln()
            iFound = recFind(phrase, yellowPages)
            if (iFound != -1) {
                recUpdate(iFound, yellowPages)
                println(texts.logSucUpdate)
                println("${texts.newValues}: ")
                println(yellowPages[iFound])
            }
            else
                println(texts.logRecNotFound)
            startOver()
        }

        fun menuDelete(yellowPages: ArrayList<Person>){
            val phrase: String?
            val index: Int
            println(texts.titleMDelete)
            print("${texts.find}: ")
            phrase = readln()
            index = recFind(phrase, yellowPages)
            if (index != -1){
                yellowPages.removeAt(index)
                println(texts.logSucDelete)
            }
            else
                println(texts.logRecNotFound)
            startOver()
        }

        private fun recUpdate(index: Int, yellowPages: ArrayList<Person>) {
            var newName: String?
            var newNumber: String?
            println(texts.infoLeaveEmpty)
            print("${texts.newName}: ")
            newName = readln()
            newName = if (newName == "") yellowPages[index].name else newName
            print("${texts.newNumber}: ")
            newNumber = readln()
            newNumber = if (newNumber == "") yellowPages[index].number else newNumber
            yellowPages[index] = Person(newName, newNumber)
        }

        private fun recFind(key: Any, yellowPages: ArrayList<Person>): Int {
            for (rec in yellowPages)
                if (rec.name == key)
                    return yellowPages.indexOf(rec)
            for (rec in yellowPages)
                if (rec.number == key)
                    return yellowPages.indexOf(rec)
            return -1
        }

        private fun recExists(rec: Person, yellowPages: ArrayList<Person>) : Boolean {
            if (yellowPages.contains(rec)) {
                println(texts.logRecExists)
                return true
            }
            return false
        }

        fun changeLang() {
            texts = when (texts.langName) {
                LangNames.ENGLISH -> LangTur()
                LangNames.TURKISH -> LangEng()
            }
            Utils.clearConsole()
            startOver()
        }
    }
}