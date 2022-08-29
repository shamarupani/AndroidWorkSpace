data class User(var name:String,var id:Int)
{
    
}
fun main()
{
   	var user1=User("shama",101)
    var user2=User("shama",101)
    println(user1)
    println(user2.toString())
    if(user1==user2)
    {
        println("Equal")
    }
    else
    {
        println("Not equal")
    }
    var user3=user1.copy()
    println(user3)
}
