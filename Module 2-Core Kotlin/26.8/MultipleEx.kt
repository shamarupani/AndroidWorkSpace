interface A1
{
    fun a1()

}
interface B1
{
    fun b1()
}
class MultipleEx :A1,B1 {
    override fun a1() {
       println("A1 details accessed")
    }

    override fun b1() {
       println("B1 details accessed")
    }
}

fun main()
{
    var m1=MultipleEx()
    m1.a1()
    m1.b1()
}