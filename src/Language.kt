abstract class Language(val langName: LangNames) {
    abstract val mainMenu: String
    abstract val pressKey: String
    // ---SMALL TEXTS---
    abstract val name: String
    abstract val number: String
    abstract val find: String
    abstract val newValues: String
    abstract val newName: String
    abstract val newNumber: String
    // ---TITLES---
    abstract val titleMList: String
    abstract val titleMAdd: String
    abstract val titleMUpdate: String
    abstract val titleMDelete: String
    // ---INFO---
    abstract val infoLeaveEmpty: String
    // ---LOGS---
    abstract val logSucUpdate: String
    abstract val logSucDelete: String
    abstract val logRecNotFound: String
}

class LangEng : Language(LangNames.ENGLISH) {
    override val mainMenu: String
        get() = """
        ******************
        * 1-List         *
        * 2-Add          *
        * 3-Update       *
        * 4-Delete       *
        * 5-Turkish      *
        * 6-Quit         *
        ******************
        """.trimIndent()
    override val pressKey: String
        get() = "Please press Enter key..."
    override val name: String
        get() = "Name"
    override val number: String
        get() = "Number"
    override val find: String
        get() = "Find"
    override val newValues: String
        get() = "New values"
    override val newName: String
        get() = "New name"
    override val newNumber: String
        get() = "New number"
    override val titleMList: String
        get() = "---List all---"
    override val titleMAdd: String
        get() = "---Add a record---"
    override val titleMUpdate: String
        get() = "---Update a record---"
    override val titleMDelete: String
        get() = "---Delete a record---"
    override val infoLeaveEmpty: String
        get() = "Leave empty to make it unchanged."
    override val logSucUpdate: String
        get() = "Successfully updated..."
    override val logSucDelete: String
        get() = "Successfully deleted."
    override val logRecNotFound: String
        get() = "Record not found."
}

class LangTur : Language(LangNames.TURKISH) {
    override val mainMenu: String
        get() = """
        ******************
        * 1-Listele      *
        * 2-Ekle         *
        * 3-Guncelle     *
        * 4-Sil          *
        * 5-English      *
        * 6-Cikis        *
        ******************
        """.trimIndent()
    override val pressKey: String
        get() = "Lutfen Enter tusuna basiniz..."
    override val name: String
        get() = "Isim"
    override val number: String
        get() = "Numara"
    override val find: String
        get() = "Bul"
    override val newValues: String
        get() = "Yeni degerler"
    override val newName: String
        get() = "Yeni isim"
    override val newNumber: String
        get() = "Yeni numara"
    override val titleMList: String
        get() = "---Hepsini listele---"
    override val titleMAdd: String
        get() = "---Yeni kayit ekle---"
    override val titleMUpdate: String
        get() = "---Kayit guncelle---"
    override val titleMDelete: String
        get() = "---Kayit sil---"
    override val infoLeaveEmpty: String
        get() = "Degistirmek istemedikleriniz icin bos birakin."
    override val logSucUpdate: String
        get() = "Guncelleme basarili..."
    override val logSucDelete: String
        get() = "Silme islemi basarili."
    override val logRecNotFound: String
        get() = "Kayit bulunamadi."
}