package com.ferhat.CepTelefonu

import Person
import LangEng
import LangNames
import LangTur
import Language
import Utils

class CellPhone {
    var currentMenu: Int = 0
    companion object {
        private var texts: Language = LangEng()

        fun menuMain() {
            println(texts.mainMenu)
        }

        private fun startOver(){
            println(texts.pressKey)
            readln()
            Utils.clearConsole()
            this.menuMain()
        }

        fun readChoose(): Int {
            print(">>")
            val response: String = readln()
            if (response == "") return 0
            when (Utils.isNumeric(response)) {
                true -> return response.toInt()
                false -> return 0
            }
        }

        fun menuList(yellowPages: ArrayList<Person>) {
            println("${texts.name}\t${texts.number}")
            for (kisi in yellowPages) {
                println("${kisi.name}:\t${kisi.number}")
            }
            this.startOver()
        }

        fun menuAdd(yellowPages: ArrayList<Person>) {
            var name: String = ""
            var number: String = ""

            println(texts.titleMAdd)
            print("${texts.name}: ")
            name = readln()
            print("${texts.number}: ")
            number = readln()
            yellowPages.add(Person(name, number))
            this.startOver()
        }

        fun menuUpdate(yellowPages: ArrayList<Person>) {
            var phrase: String = ""
            var i_found: Int = -1

            println(texts.titleMUpdate)
            print("${texts.find}: ")
            phrase = readln()
            i_found = recFind(phrase, yellowPages)
            if (i_found != -1) {
                recUpdate(i_found, yellowPages)
                println(texts.logSucUpdate)
                println("${texts.newValues}: ")
                println(yellowPages.get(i_found))
            }
            else
                println(texts.logRecNotFound)
            this.startOver()
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
            this.startOver()
        }

        fun recUpdate(index: Int, yellowPages: ArrayList<Person>) {
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

        fun recFind(key: Any, yellowPages: ArrayList<Person>): Int {
            for (rec in yellowPages)
                if (rec.name == key)
                    return yellowPages.indexOf(rec)
            for (rec in yellowPages)
                if (rec.number == key)
                    return yellowPages.indexOf(rec)
            return -1
        }

        fun changeLang() {
            if (texts.langName == LangNames.ENGLISH)
                texts = LangTur()
            else if (texts.langName == LangNames.TURKISH)
                texts = LangEng()
            else
                return
            Utils.clearConsole()
            this.startOver()
        }
    }
}