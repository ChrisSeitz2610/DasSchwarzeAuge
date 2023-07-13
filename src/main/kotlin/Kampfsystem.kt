open class Kampfsystem(private var held: Charakter) {


    private val heldenListe = listOf(
        Charakter("Frenja Halmansdottir", 100, "Skarja-Axt", 6, 9),
        Charakter("Lyra Schattenflug", 110, "Kurzschwert", 6, 8),
        Charakter("Gandar Eisenfaust", 120, "Langschwert", 7, 9),
        Charakter("Aurelia Sturmwind", 90, "gekrümmter Langdolch", 5, 8),
        Charakter("Eldarion Windbrecher", 80, "Flammenspeer", 7, 9)
    )

    private val gegnerliste = listOf(
        Gegner("Ork-Rekrut", 20, "schartiges Trainingsschwert", 1, 4),
        Gegner("Ork-Soldat", 30, "Ork-Säbel", 2, 6),
        Gegner("Ork-Berserker", 40, "Streitaxt", 4, 8),
        Gegner("Ork-Häuptling", 50, "Kriegshammer", 5, 10)
    )

    fun traenke (): List<Items> {
        val trank1 = Items("kleiner Heiltrank", 10)
        val trank2 = Items("mittlerer Heiltrank", 25)
        val trank3 = Items("großer Heiltrank", 35)
        val trank4 = Items("Trank der Götter", 70)

        return listOf(trank1, trank2, trank3, trank4).shuffled()
    }
    val zufallListe = traenke()
    val zufaelligerTrank = zufallListe.first()

    fun wuerfelWurf(seiten: Int) : Int {
        return (1..seiten).random()
    }

    fun schadenErmitteln(minSchaden: Int, maxSchaden: Int): Int {
        return (minSchaden..maxSchaden).random()
    }

    fun starteKampf() {
        var kampfAnzahl = 0


        while (kampfAnzahl < 2 && held.lebensPunkte > 0) {
            kampfAnzahl++
            println()
            println("Ein Gegner stürmt auf dich zu!")

            println()
            val zufallsGegner = gegnerliste.random()
            println("${held.name} (Aktuelle LP: ${held.lebensPunkte}) tritt gegen ${zufallsGegner.name} (Aktuelle LP: ${zufallsGegner.lebensPunkte}) an!")

            while (held.lebensPunkte > 0 && zufallsGegner.lebensPunkte > 0) {
                println()
                Thread.sleep(1500)
                println("Drücke Enter, um deinen Angriff zu starten!")
                readln()
                Thread.sleep(1500)

                val heldWurf = wuerfelWurf(20)
                if (heldWurf in 1..12) {
                    val heroAttack = schadenErmitteln(held.minSchaden, held.maxSchaden) // Hilfe von meiner Gruppe
                    zufallsGegner.lebensPunkte -= heroAttack // Hilfe von meiner Gruppe
                    println("Dein Angriff gegen ${zufallsGegner.name} war erfolgreich! Du verursachst ${heroAttack} Schaden!")


                } else {
                    println("Dein Angriff ist misslungen!")
                }
                if (zufallsGegner.lebensPunkte <= 0) {
                    println("Der Feind wurde besiegt!")
                    println()
                    //held.lebensPunkte += zufaelligerTrank
                    break
                }
                println()
                Thread.sleep(1500)
                println("Drücke Enter, um den Angriff deines Gegners zu starten!")
                readln()
                Thread.sleep(1500)
                val gegnerWurf = wuerfelWurf(20)
                if (gegnerWurf in 1..12) {
                    val enemyAttack = schadenErmitteln(zufallsGegner.minSchaden, zufallsGegner.maxSchaden) // Hilfe von meiner Gruppe
                    held.lebensPunkte -= enemyAttack // Hilfe von meiner Gruppe
                    println("${zufallsGegner.name} greift dich an und verursacht ${enemyAttack} Schaden!")
                } else {
                    println("Der Angriff des Gegners ist misslungen!")
                }
                if (held.lebensPunkte <= 0) {
                    println("${held.name} wurde besiegt! GAME OVER!")
                    return
                }
            }
        }
        if (kampfAnzahl == 2 && held.lebensPunkte > 0) {
            println("Du hast die Kämpfe überlebt und noch ${held.lebensPunkte} Lebenspunkte übrig! Gut gemacht! Du bist frei!")
        }
    }
}