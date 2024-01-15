import DibujoAhorcado.dibujar


fun main(args: Array<String>) {

    val rm = ReproductorMidi("pugnodollari.mid")
    println("    CARGANDO........")
    Thread.sleep(10000)

    var flores: MutableList<String> = mutableListOf()
    flores.add("rosa")
    flores.add("clavel")
    flores.add("dalia")
    flores.add("azucena")
    flores.add("gladiolo")
    flores.add("margarita")
    flores.add("calendula")
    flores.add("jazmin")
    flores.add("narciso")
    flores.add("anemona")
    flores.add("cineraria")
    flores.add("gazania")
    flores.add("gitanilla")
    flores.add("jacinto")
    flores.add("ixora")
    flores.add("hibisco")
    flores.add("petunia")
    flores.add("lavanda")

    var rnd = (0..flores.size-1).random()
    val flor = flores[rnd]

    println(" Debes adivinar el nombre de una flor")
    var elegida = ""
    for(item in 0..flor.length-1){
        elegida += "*"
    }
    var asteriscos = flor.length
    println(elegida)
    //println(flor)
    val maxFallos = 7
    var fallos = 0
    while((fallos < maxFallos) && asteriscos>0){

        print(" teclea una letra--> ")
        var letraLeida = readln()
        var letraCaracter = letraLeida
        var acertada = false
        for(item in 0.. flor.length-1){
            if(flor[item].equals(letraLeida[0])){
                elegida = elegida.substring(0,item) + letraLeida[0] + elegida.substring(item+1,flor.length)
                asteriscos--
                acertada = true
                //print(" -- $acertada  -- ")

            }
        }
        if(!acertada){
            fallos++
            val dib = dibujar(fallos)
        }
        println(elegida)
        //println("asteriscos $asteriscos")
        //println(acertada)
        //println("fallos $fallos")
        acertada = false

    }
    if(asteriscos==0){
        println(" Enhorabuena, has acertado la flor --> ${flores[rnd]}")
    }else{
        println(" Lo siento has fallada, la flor era --> ${flores[rnd]}")
    }
    Thread.sleep(4000)
    rm.cerrar()

}