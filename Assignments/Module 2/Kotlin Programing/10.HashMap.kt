fun main()
{
    var myMap=HashMap<String,String>()
    myMap.put("Gujarat","Rajkot")
    myMap.put("Rajasthan","Jaipur")
    myMap.put("Maharashtra","Mumbai")

    for (key in myMap.keys)
    {
        println("Element at key: $key=${myMap[key]}")
    }

}