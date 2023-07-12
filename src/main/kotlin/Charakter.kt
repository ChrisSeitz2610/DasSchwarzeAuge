open class Charakter(
    var name: String,
    var lebensPunkte: Int,
    var waffen: String,
    var minSchaden: Int,
    var maxSchaden: Int
) {

    var lebensPunkte2: Int = 0

    fun heilen(heilung: Int) {
        lebensPunkte2 += heilung
    }
}

class Trank(
    var name: String,
    var heilung: Int
)

val held = Charakter("", 0, "", 0, 0)
val traenkeListe = listOf(
    Trank("kleiner Heiltrank", 10),
    Trank("mittlerer Heiltrank", 25),
    Trank("großer Heiltrank", 35),
    Trank("Trank der Götter", 70)
)

val zufaelligerTrank = traenkeListe.randomOrNull()




