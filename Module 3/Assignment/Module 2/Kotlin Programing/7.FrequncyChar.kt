fun main()
{
    var s = "tops technologies"
    var ch = 's'
    var frequency = 0
    for (i in 0..s.length -1)
    {
        if (ch==s[i])
        {
            frequency++
        }
    }
    println("Frequency of $ch is $frequency")

}