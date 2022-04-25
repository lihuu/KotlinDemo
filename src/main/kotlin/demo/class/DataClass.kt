package demo.`class`

data class DataClass(val a: Int) {
}

object Resource {
    val name = "Alex"

    fun say() {
        println("Hello")
    }
}

class Singleton{
    companion object Instance{
        
    }
    
}

fun main() {
    Singleton.Instance
}