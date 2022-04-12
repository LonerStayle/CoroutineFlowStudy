package kotlin_test.coroutine_flow.first.`04_suspend_fun`

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun random03_1(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun random03_2(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

/*async 키워드를 사용하는 순간 코드 블록이 수행을 준비하는데, async(start = CoroutineStart.LAZY)로
인자를 전달하면 우리가 원하는 순간 수행을 준비하게 할 수 있습니다.*/

/*이후 start 메서드를 이용해 수행을 준비하게 할 수 있습니다.*/
fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async(start = CoroutineStart.LAZY) { random03_1() }
        val value2 = async(start = CoroutineStart.LAZY) { random03_2() }

        value1.start()
        value2.start()

        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    }
    println(elapsedTime)
}