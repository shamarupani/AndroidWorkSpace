open class A
{
    fun A()
    {
        println("A details accessed")
    }
}
open class B:A()
{
    fun B()
    {
        println("B details accessed")
    }
}
class C:B()
{
    fun C()
    {
        println("C details accessed")
    }
}
fun main()
{
    var c=C()
    c.A()
    c.B()
    c.C()
}
