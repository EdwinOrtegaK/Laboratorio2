fun main(){
    val listaNumeros = listOf(1, 2, 3, 4, 5)
    val promedio = calcularPromedio(listaNumeros)
    val numerosImpares = filtrarNumerosImp(listaNumeros)
    val cadena1 = "reconocer"
    val cadena2 = "oso"
    val cadena3 = "andres"
    val nombres = listOf("Andrea", "Carlos", "Ricky", "Gerson", "Esteban")
    val saludos = agregarSaludo(nombres)

    println("El promedio es: $promedio")
    println("La lista de numeros impares es: $numerosImpares")
    println("¿'$cadena1' es un palíndromo? ${isPalindrome(cadena1)}")
    println("¿'$cadena2' es un palíndromo? ${isPalindrome(cadena2)}")
    println("¿'$cadena3' es un palíndromo? ${isPalindrome(cadena3)}")
    saludos.forEach { println(it) }
}

fun calcularPromedio(listaNumeros: List<Int>): Int {
    // Utilizamos la función de reducción `reduce` para sumar los elementos de la lista
    val sumaTotal = listaNumeros.reduce { acc, num -> acc + num }

    // Calculamos el promedio dividiendo la suma total entre la cantidad de elementos en la lista
    return sumaTotal.toInt() / listaNumeros.size
}

fun filtrarNumerosImp(listaNumeros: List<Int>): List<Int>{
    return listaNumeros.filter { it % 2 != 0}
}

fun isPalindrome(cadena: String): Boolean {
    return cadena == cadena.reversed()
}

fun agregarSaludo(nombres: List<String>): List<String> {
    return nombres.map { "¡Hola, $it!" }
}