fun main()
{
    println("Enter a number")
    var num1= readLine()!!.toInt()
    if (num1%2==0)
    {
        println("The number is Even")
    }
    else
    {
        println("The number is Odd")
    }
}