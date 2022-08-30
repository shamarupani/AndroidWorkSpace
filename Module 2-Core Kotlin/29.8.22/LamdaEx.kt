class LamdaEx
{
    fun addtwonum(a:Int,b:Int,action:(Int)->Unit)
    {
        val sum=a+b
        action(sum)
    }
}
fun main()
{
    val my = LamdaEx()
    val myLambda: (Int) -> Unit = { s: Int -> println(s) }
    my.addtwonum(5, 7, myLambda)
}