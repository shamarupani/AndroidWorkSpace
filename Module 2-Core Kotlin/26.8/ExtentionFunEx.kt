
class Myfirstclass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks>40
    }
}
fun Myfirstclass.isscholar(marks2: Int) :Boolean
{
    return marks2>90
}
fun main()
{
    var m= Myfirstclass()
    println("passing status:"+m.hasPassed(55) )
  println("Scolarship status:"+m.isscholar(55))
}
