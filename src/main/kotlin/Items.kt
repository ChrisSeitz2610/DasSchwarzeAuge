import kotlin.random.Random

open class Items (var name: String, heal: Int) {


}
// hat leider nicht so funktioniert wie ich es mir vorgestellt hatte

fun main() {
    fun traenke (): List<Items> {
        val trank1 = Items("kleiner Heiltrank", 10)
        val trank2 = Items("mittlerer Heiltrank", 25)
        val trank3 = Items("großer Heiltrank", 35)
        val trank4 = Items("Trank der Götter", 70)

        return listOf(trank1, trank2, trank3, trank4).shuffled()
    }
    val zufallListe = traenke()
    val zufaelligerTrank = zufallListe.first()

    //for (traenke in Items)
    println("${zufaelligerTrank.name}")
}