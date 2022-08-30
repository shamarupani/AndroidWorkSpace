class throwsEx
{
    fun validate(age:Int)
    {
        if(age>18)
        {
            println("Eligible to vote")
        }
        else
        {
            throw ArithmeticException("age is not valid")
        }
    }
}
fun main()
{
    var v=throwsEx()
    v.validate(14)
}