open class Kampfsystem(private var held: Charakter) {


    private val heldenListe = listOf(
        Charakter("Frenja Halmansdottir", 35, "Skarja-Axt", 5, 7),
        Charakter("Lyra Schattenflug", 30, "Kurzschwert", 3, 7),
        Charakter("Gandar Eisenfaust", 40, "Langschwert", 4, 8),
        Charakter("Aurelia Sturmwind", 28, "Langdolch", 3, 6),
        Charakter("Eldarion Windbrecher", 25, "Speer", 3, 7)
    )

    private val gegnerliste = listOf(
        Gegner("Ork-Rekrut", 20, "schartiges Trainingsschwert", 1, 4),
        Gegner("Ork-Soldat", 30, "Ork-Säbel", 2, 6),
        Gegner("Ork-Berserker", 40, "Streitaxt", 4, 8),
        Gegner("Ork-Häuptling", 50, "Kriegshammer", 5, 10)
    )

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
                println("Drücke Enter, um deinen Angriff zu starten!")
                readln()

                val heldWurf = wuerfelWurf(20)
                if (heldWurf in 1..12) {
                    val heroAttack = schadenErmitteln(held.minSchaden, held.maxSchaden)
                    zufallsGegner.lebensPunkte -= heroAttack
                    println("Dein Angriff gegen ${zufallsGegner.name} war erfolgreich! Du verursachst ${heroAttack} Schaden!")

//                    val heilTrankDrop = Items(name = "", heal = 0)
//                    println("Ein ${heilTrankDrop} wurde gedroppt!")
//                    if (zufaelligerTrank != null) {
//                        held.heilen(zufaelligerTrank.heilung)
//                        println("Du wurdest um ${zufaelligerTrank.heilung} Lebenspunkte geheilt. Aktuelle LP: ${held.lebensPunkte}")
//                    }
                } else {
                    println("Dein Angriff ist misslungen!")
                }
                if (zufallsGegner.lebensPunkte <= 0) {
                    println("Der Feind wurde besiegt!")
                    break
                }
                println()
                println("Drücke Enter, um den Angriff deines Gegners zu starten!")
                readln()
                val gegnerWurf = wuerfelWurf(20)
                if (gegnerWurf in 1..12) {
                    val enemyAttack = schadenErmitteln(zufallsGegner.minSchaden, zufallsGegner.maxSchaden)
                    held.lebensPunkte -= enemyAttack
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
        if (kampfAnzahl == 5 && held.lebensPunkte > 0) {
            println("Du hast die Kämpfe überlebt! Gut gemacht! Du bist frei!")
        }
    }
}