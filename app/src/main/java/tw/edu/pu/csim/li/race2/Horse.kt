package tw.edu.pu.csim.li.race2

class Horse() {

    var HorseX = 0
    var HorseY = 100

    var HorseNO = 0

    fun Run(){
        HorseNO++
        if (HorseNO>3) {
            HorseNO= 0
        }
        HorseX += (10..30).random()
    }
}

