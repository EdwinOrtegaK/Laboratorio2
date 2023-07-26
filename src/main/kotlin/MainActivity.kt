fun main(){
    val listaNumeros = listOf(1, 2, 3, 4, 5)
    val promedio = calcularPromedio(listaNumeros)
    val numerosImpares = filtrarNumerosImp(listaNumeros)
    val cadena1 = "reconocer"
    val cadena2 = "oso"
    val cadena3 = "andres"
    val nombres = listOf("Andrea", "Carlos", "Ricky", "Gerson", "Esteban")
    val saludos = agregarSaludo(nombres)
    val resultadoSuma = performOperation(10, 5) { a, b -> a + b }
    val resultadoResta = performOperation(10, 5) { a, b -> a - b }
    val peopleList = listOf(
        Person("Andres", 20, "M"),
        Person("Jimena", 22, "F"),
        Person("May", 19, "F")
    )
    val studentsList = mapToStudent(peopleList)


    println("El promedio es: $promedio")
    println("La lista de numeros impares es: $numerosImpares")
    println("¿'$cadena1' es un palíndromo? ${isPalindrome(cadena1)}")
    println("¿'$cadena2' es un palíndromo? ${isPalindrome(cadena2)}")
    println("¿'$cadena3' es un palíndromo? ${isPalindrome(cadena3)}")
    saludos.forEach { println(it) }
    println("Resultado de la suma entre 10 y 5 es: $resultadoSuma")
    println("Resultado de la resta entre 10 y 5 es: $resultadoResta")
    studentsList.forEach { student ->
        println("El/La estudiante ${student.name} tiene ${student.age} años")
    }
}

data class Person(val name: String, val age: Int, val gender: String)

data class Student(val name: String, val age: Int, val gender: String, val StudentId: String)

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

fun performOperation(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

fun mapToStudent(peopleList: List<Person>): List<Student> {
    return peopleList.map { person ->
        Student(person.name, person.age, person.gender, generateStudentId())
    }
}

fun generateStudentId(): String {
    // Código para generar un ID de estudiante único
    // Por simplicidad, usando una cadena aleatoria
    return "ID-${(0..100).random()}"
}