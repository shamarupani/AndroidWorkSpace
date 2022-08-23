fun main()
{
    println("Enter your choice")
    var choice= readLine()!!.toInt()

    when(choice)
    {
        1 ->
        {
            println("your selected language is english")
        }
        2 ->
        {
            println("your selected language is hindi")
        }
        3 ->
        {
            println("your selected language is gujarati")
        }
    }
}