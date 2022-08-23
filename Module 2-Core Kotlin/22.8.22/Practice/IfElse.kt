fun main()
{
    println("Enter your marks")
    var marks= readLine()!!.toInt()

    var max= if (marks>35) println("pass") else println("fail")
    println(max)
    

    /*if (marks>=70)
    {
        println("A grade")
    }
    else if (marks>=60)
    {
        println("B grade")
    }
    else if (marks>=50)
    {
        println("C grade")
    }
    else
    {
        println("Fail")
    }*/
}