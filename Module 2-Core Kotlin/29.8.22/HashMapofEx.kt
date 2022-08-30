fun main()
{
        var myMap=HashMap<Int,String>()
        myMap.put(1,"Java")
        myMap.put(2,"Kotlin")
        myMap.put(3,"Sql")

    for (key in myMap.keys)
    {
        println("Element at key :$key = ${myMap.keys}")
    }
}