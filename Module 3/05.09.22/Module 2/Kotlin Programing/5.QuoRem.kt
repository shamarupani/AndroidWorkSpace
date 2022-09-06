fun main()
{
    println("Enter first number:")
    var num1= readLine()!!.toInt()
    println("Enter second number:")
    var num2= readLine()!!.toInt()
    var quotient=num1/num2
    var reminder=num1%num2
    println("Quotient of two numbers is:$quotient")
    println("Remainder of two numbers is:$reminder")
}