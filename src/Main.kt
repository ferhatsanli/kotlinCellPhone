import com.ferhat.CepTelefonu.CellPhone

// Bir cep telefonunun bazi özelliklerini yapabilen bir uygulama yapiniz. Bu uygulama ;
// Rehbere kisi eklevebilmeli, sorgulavabilmeli, kisileri silip güncellevebilmeli
// Bir kisi eklenirken veya güncellenirken o kisinin olup olmadini kontrol edebilmeli
// Telefon menüsünde cikis, tüm kisileri listele, yeni kisi ekle, kisi güncelle ve kisi sil olmali

//IPUCU:
//kisi sinifi olusturabilirsiniz ve tüm kisileri tutan bir arraylist'e sahip CepTelefonu sunifiniz olsun.

/*
* Rehber -> arraylist<Kisi>
* Kisi -> class
* CepTelefonu -> class w/ functions
* */
fun main() {
    var rehber = ArrayList<Person>()
    rehber.add(Person("ferhat", "12354643"))
    Utils.clearConsole()
    CellPhone.menuMain()
    while (true) {
        when (CellPhone.readChoose()) {
            1 -> CellPhone.menuList(rehber)
            2 -> CellPhone.menuAdd(rehber)
            3 -> CellPhone.menuUpdate(rehber)
            4 -> CellPhone.menuDelete(rehber)
            5 -> CellPhone.changeLang()
            6 -> return
        }
    }
}

