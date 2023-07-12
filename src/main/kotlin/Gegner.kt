open class Gegner(
    var name: String,
    var lebensPunkte: Int,
    var waffen: String,
    var minSchaden: Int,
    var maxSchaden: Int) {

    var schaden:() -> Int = {0}

}