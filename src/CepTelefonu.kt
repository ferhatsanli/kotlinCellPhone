package com.ferhat.CepTelefonu

import Kisi
import Utils

class CepTelefonu {
    var currentMenu: Int = 0

    companion object {
        fun menuAnaMenu() {
//            Utils.clearConsole()
            println(Menus.mainMenu)
        }

        private fun basaDon(){
            println("Bir tusa basiniz...")
            readln()
            Utils.clearConsole()
            this.menuAnaMenu()
//            this.menuAnaMenu()
        }

        fun readChoose(): Int {
            print(">>")
            val cevap: String = readln()
            if (cevap == "") return 0
            when (Utils.isNumeric(cevap)) {
                true -> return cevap.toInt()
                false -> return 0
            }
        }

        fun menuListele(rehber: ArrayList<Kisi>) {
//            Utils.clearConsole()
            println("Isim\tNumara")
            for (kisi in rehber) {
                println("${kisi.isim}:\t${kisi.numara}")
            }
            this.basaDon()
        }

        fun menuEkle(rehber: ArrayList<Kisi>) {
            var isim: String = ""
            var numara: String = ""

//            Utils.clearConsole()
            println("---Kisi Ekle---")
            print("Isim: ")
            isim = readln()
            print("Numara: ")
            numara = readln()
            rehber.add(Kisi(isim, numara))
            this.basaDon()
        }

        fun menuGuncelle(rehber: ArrayList<Kisi>) {
            var phrase: String = ""
            var i_found: Int = -1

//            Utils.clearConsole()
            println("---Kisi Guncelle---")
            print("Bul: ")
            phrase = readln()
            i_found = kisiBul(phrase, rehber)
            if (i_found != -1) {
                kisiGuncelle(i_found, rehber)
                println("Kisi basariyla guncellendi.")
                println("Yeni degerler:")
                println(rehber.get(i_found))
            }
            else
                println("Kullanici bulunamadi.")
            this.basaDon()
        }

        fun menuSil(rehber: ArrayList<Kisi>){
            val phrase: String?
            val index: Int
            println("---Kisi Sil---")
            print("Bul: ")
            phrase = readln()
            index = kisiBul(phrase, rehber)
            if (index != -1){
                rehber.removeAt(index)
                println("Silme islemi basarili.")
            }
            else
                println("Kisi bulunamadi.")
            this.basaDon()
        }

        fun kisiGuncelle(index: Int, rehber: ArrayList<Kisi>) {
            var yeniAd: String?
            var yeniNumara: String?
            println("Degistirmek istemedikleriniz icin bos birakin.")
            print("Yeni isim: ")
            yeniAd = readln()
            yeniAd = if (yeniAd == "") rehber.get(index).isim else yeniAd
            print("Yeni numara:")
            yeniNumara = readln()
            yeniNumara = if (yeniNumara == "") rehber.get(index).numara else yeniNumara
            rehber.set(index, Kisi(yeniAd, yeniNumara))
        }

        fun kisiBul(key: Any, rehber: ArrayList<Kisi>): Int {
            for (kisi in rehber)
                if (kisi.isim == key)
                    return rehber.indexOf(kisi)
            for (kisi in rehber)
                if (kisi.numara == key)
                    return rehber.indexOf(kisi)
            return -1
        }
    }
}