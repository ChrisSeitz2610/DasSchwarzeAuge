fun main() {
    val held1Auswahl = Charakter(
        "Frenja Halmansdottir",
        100,
        "Skarja-Axt",
        6,
        9
    )

    val held2Auswahl = Charakter(
        "Lyra Schattenflug",
        110,
        "Kurzschwert",
        6,
        8
    )

    val held3Auswahl = Charakter(
        "Gandar Eisenfaust",
        120,
        "Langschwert",
        7,
        9
    )

    val held4Auswahl = Charakter(
        "Aurelia Sturmwind",
        90,
        "gekrümmter Langdolch",
        5,
        8
    )

    val held5Auswahl = Charakter(
        "Eldarion Windbrecher",
        80,
        "Flammenspeer",
        7,
        9
    )

    val helden = listOf(held1Auswahl, held2Auswahl, held3Auswahl, held4Auswahl, held5Auswahl)

    val enemy = Gegner(
        "Ork-Rekrut",
        20,
        "schartiges Trainingsschwert",
        1,
        4
    )

    val enemy1 = Gegner(
        "Ork-Soldat",
        30,
        "Ork-Säbel",
        2,
        6
    )

    val enemy2 = Gegner(
        "Ork-Berserker",
        40,
        "Streitaxt",
        4,
        8
    )

    val enemy3 = Gegner(
        "Ork-Häuptling",
        50,
        "Kriegshammer",
        5,
        10
    )

    listOf(enemy, enemy, enemy1, enemy1, enemy2, enemy3)

    println("Willkommen in")
    Thread.sleep(2000)
    println(
        " _______       ___           _______.        _______.  ______  __    __  ____    __    ____  ___      .______      ________   _______         ___      __    __    _______  _______ \n" +
                "|       \\     /   \\         /       |       /       | /      ||  |  |  | \\   \\  /  \\  /   / /   \\     |   _  \\    |       /  |   ____|       /   \\    |  |  |  |  /  _____||   ____|\n" +
                "|  .--.  |   /  ^  \\       |   (----`      |   (----`|  ,----'|  |__|  |  \\   \\/    \\/   / /  ^  \\    |  |_)  |   `---/  /   |  |__         /  ^  \\   |  |  |  | |  |  __  |  |__   \n" +
                "|  |  |  |  /  /_\\  \\       \\   \\           \\   \\    |  |     |   __   |   \\            / /  /_\\  \\   |      /       /  /    |   __|       /  /_\\  \\  |  |  |  | |  | |_ | |   __|  \n" +
                "|  '--'  | /  _____  \\  .----)   |      .----)   |   |  `----.|  |  |  |    \\    /\\    / /  _____  \\  |  |\\  \\----. /  /----.|  |____     /  _____  \\ |  `--'  | |  |__| | |  |____ \n" +
                "|_______/ /__/     \\__\\ |_______/       |_______/     \\______||__|  |__|     \\__/  \\__/ /__/     \\__\\ | _| `._____|/________||_______|   /__/     \\__\\ \\______/   \\______| |_______|\n" +
                "                                                                                                                                                                                    "
    )
    Thread.sleep(2500)
    println("Wähle einen Helden aus:")
    for ((index, held) in helden.withIndex()) {
        println("${index + 1}. ${held.name} - Lebenspunkte: ${held.lebensPunkte} - Waffe: ${held.waffen}")
    }

    val ausgewaehlterHeldIndex = readln().toInt()

    if (ausgewaehlterHeldIndex in 1..helden.size) {
        val ausgewaehlterHeld = helden[ausgewaehlterHeldIndex - 1]
        println("Du hast ${ausgewaehlterHeld.name} ausgewählt.")
    } else {
        println("Ungültige Auswahl.")
    }


    Thread.sleep(1500)
    println()
    // Story
    println("Nach einem misslungenen Auftrag findest du dich in der Zelle einer Orkfestung wieder.")
    Thread.sleep(2500)
    println("Deine Mitstreiter und du wurden gezwungen nacheinander in der Arena gegen Orks zu kämpfen.")
    Thread.sleep(2500)
    println("Nur noch du bist übrig!")
    Thread.sleep(2500)
    println("Du hörst Schritte im Zellenbereich.")
    Thread.sleep(2500)
    println("Drei fies grinsende Orks betreten deine Zelle und packen dich.")
    Thread.sleep(2500)
    println("'Du bist dran!', faucht der Größere der drei.")
    Thread.sleep(2500)
    println("Sie führen dich in die Arena.")
    Thread.sleep(2500)
    println("Dort angekommen lösen sie deine Fesseln und werfen dir deine Waffe zu.")
    Thread.sleep(2000)
    println()
    var held = helden.get(ausgewaehlterHeldIndex -1)
    val kampfsystem = Kampfsystem(held)
    kampfsystem.starteKampf()
}

