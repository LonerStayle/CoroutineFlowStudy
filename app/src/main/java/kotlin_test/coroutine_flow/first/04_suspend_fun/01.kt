package kotlin_test.coroutine_flow.first.`04_suspend_fun`

/*import kotlin.random.Random은 Random.nextInt를 위해 추가하였습니다.*/
/*import kotlin.system.*는 measureTimeMillis를 위해 추가하였습니다.*/
import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun getRandom1(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun getRandom2(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

/*대략 2000ms 이상 수행된다는 것을 볼 수 있습니다.*/
/*순차적으로 수행되었기 때문에 getRandom1이 1000ms 정도를 소비하고 getRandom2가 1000ms 정도 소비하는 것입니다.*/
fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = getRandom1()
        val value2 = getRandom2()
        println("${value1} + ${value2} = ${value1 + value2}")
    }
    println(elapsedTime)
}
