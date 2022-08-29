open class Bank
{
    fun bank()
    {
        println("Bank details accessed")
    }
}
class Current : Bank()
{
    fun current()
    {
        println("Current details")
    }
}
class Saving:Bank()
{
    fun saving()
    {
        println("Saving details")
    }
}
fun main()
{
    var c=Current()
    var s=Saving()
    c.current()
    c.bank()
    s.saving()
}