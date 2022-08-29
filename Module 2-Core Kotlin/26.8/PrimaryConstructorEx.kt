class PrimaryConstructorEx(var id:Int,var name:String)
{
    fun detail()
    {
        println("Your id is $id")
        println("Your name is $name")

    }
}

fun main()
{
    var c1=PrimaryConstructorEx(102,"Shama")
    c1.detail()
}