import java.io.FileOutputStream

fun main()
{
    var s="Welcome to Tops"
    var fout=FileOutputStream("D://yasin.txt")
    fout.write(s.toByteArray())
    println("Success")
}