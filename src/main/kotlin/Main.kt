import DibujoAhorcado.dibujar


fun main(args: Array<String>) {

    val rm = ReproductorMidi("pugnodollari.mid")
    println("    VAMOS A JUGAR AL AHORCADO\n")
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


    var elegida = ""
    for(item in 0..flor.length-1){
        elegida += "*"
    }
    var asteriscos = flor.length
    val maxFallos = 7
    var fallos = 0
    var intentadas = " "
    while((fallos < maxFallos) && asteriscos>0){

        println(" Debes adivinar el nombre de una flor ==>  $elegida")
        println(" Tienes $fallos (el máximo permitido son 7)")
        print(" teclea una letra a ver si aciertas --> ")
        var letraLeida = readln()
        var letraRepetida = false
        for(item in 0..intentadas.length-1){
            if(letraLeida[0]==intentadas[item]){
                letraRepetida = true
            }
        }

        if(letraRepetida){
            println("\n  ESA LETRA YA LA ELEGISTE, PRUEBA OTRA VEZ\n")
        }else{
            intentadas += letraLeida
            var acertada = false

            for(item in 0.. flor.length-1){
                if(flor[item].equals(letraLeida[0])){
                    elegida = elegida.substring(0,item) + letraLeida[0] + elegida.substring(item+1,flor.length)
                    asteriscos--
                    acertada = true
                }
            }
            println("\n\n")
            if(!acertada){
                fallos++
                val dib = dibujar(fallos)
            }
            acertada = false
        }
    }//fin del while
    if(asteriscos==0){
        println(" Enhorabuena, has acertado, la flor era" +
                "a" +
                "a" +
                "--> ${flores[rnd].uppercase()}")
    }else{
        println(" Lo siento has fallado, la flor era --> ${flores[rnd].uppercase()}")
    }
    Thread.sleep(4000)
    rm.cerrar()

}