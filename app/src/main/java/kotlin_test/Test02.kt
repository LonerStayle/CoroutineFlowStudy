package kotlin_test

val list = listOf(1,2,3)
fun main() {
    //카피할 경우
    list.toMutableList().add(4)
    println(list.size) // 3

    //캐스팅 할경우
    if(list is MutableList){
        list.add(4) //Error
        println(list.size)
    }
}