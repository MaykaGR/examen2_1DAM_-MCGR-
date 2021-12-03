import kotlin.math.*

//Definición de clase punto, x e y son las coordenadas; ID es el identificador
class Punto(val ID: String) {
    var x = 0
    var y = 0

    //Segundo constructor
    constructor (x: Int, y: Int, ID: String) : this(ID) {
        this.x = x
        this.y = y
    }

    init {
        //Función para obtener coordenadas como un tipo Pair
        fun obtenerCoordenadas(ID: String): Pair<Int, Int> {
            val coordenadas = x to y
            return coordenadas
        }
    }

    //Función toString modificada para que muestre la información de una instancia de punto
    override fun toString(): String {
        return "punto <$ID> -> [<$x>,<$y>]"
    }

    //Companion object para poder crear dentro los métodos estáticos o de clase
    companion object {
        //Método de clase que resta las coordenadas de dos puntos para retornar un nuevo punto, con los ID
        //de ambos puntos unidos, las coordenadas en x restadas y las coordenadas en y restadas.
        fun componenteDeVector(punto1: Punto, punto2: Punto): String {
            var ids = (punto1.ID + punto2.ID)
            var x = (punto2.x - punto1.x)
            var y = (punto2.y - punto1.y)
            return "ID: $ids,X: $x,Y: $y"
        }

        //Método estático que obtiene la diferencia entre dos puntos (sabría hacerlo en menos líneas pero
        //creo que así queda más legible)
        fun distancia(punto1: Punto, punto2: Punto): Double {
            var x1 = punto1.x.toDouble()
            var x2 = punto2.x.toDouble()
            var y1 = punto1.y.toDouble()
            var y2 = punto2.y.toDouble()
            var d = sqrt(((x2 - x1).pow(2)) + ((y2 - y1).pow(2)))
            return d
        }

        //Método estático para asignar cada punto a su localización geográfica
        fun localizacionGeograficaNS(puntos: Array<Punto>): MutableMap<String, MutableList<Punto>> {
            var localizados: MutableMap<String, MutableList<Punto>> =
                mutableMapOf("Norte" to mutableListOf(), "Sur" to mutableListOf())
            //Contador para establecer el punto en el array que vamos a comparar en cada ciclo
            var contador: Int = 0
            for (pto in puntos) {
                if (pto.y >= 0) {
                    localizados.get("Norte")?.add(pto)
                } else localizados.get("Sur")?.add(pto)
                contador = contador + 1
            }
            return localizados
        }
    }
}

fun main() {
    //Declaración del primer objeto de tipo Punto
    var punto1 = Punto(3, 2, "pA")
    var punto2 = Punto(1, 3, "pB")
    //Prueba para componenteDeVector
    print("Resultado de resta entre dos puntos: ")
    println(Punto.componenteDeVector(punto1, punto2))
    var p1 = Punto(-1, 0, "p1")
    var p2 = Punto(3, -1, "p2")
    var punto3 = Punto(-4, 4, "p3")
    var punto4 = Punto(-3, 2, "p4")
    var punto5 = Punto(6, -4, "p5")
    var punto6 = Punto(-5, 6, "p6")
    var punto7 = Punto(10, -8, "p7")
    var punto8 = Punto(1, 5, "p8")
    var punto9 = Punto(6, -7, "p9")
    //Array de puntos
    var lista: Array<Punto> = arrayOf(p1, p2, punto3, punto4, punto5, punto6, punto7, punto8, punto9)
    //Prueba de método estático localizacionGeograficaNS
    print("Localización geofráfica: ")
    println(Punto.localizacionGeograficaNS(lista))
}