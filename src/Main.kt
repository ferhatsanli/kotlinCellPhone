import com.ferhat.CepTelefonu.CepTelefonu

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
    var rehber = ArrayList<Kisi>()
    rehber.add(Kisi("ferhat", "12354643"))
    Utils.clearConsole()
    CepTelefonu.menuAnaMenu()
    while (true) {
        when (CepTelefonu.readChoose()) {
            1 -> CepTelefonu.menuListele(rehber)
            2 -> CepTelefonu.menuEkle(rehber)
            3 -> CepTelefonu.menuGuncelle(rehber)
            4 -> CepTelefonu.menuSil(rehber)
            5 -> return
        }
    }
}

