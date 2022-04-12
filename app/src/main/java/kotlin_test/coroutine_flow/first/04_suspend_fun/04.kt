package kotlin_test.coroutine_flow.first.`04_suspend_fun`

import kotlin.random.Random
import kotlinx.coroutines.*

suspend fun random04_1(): Int {
    try {
        delay(1000L)
        return Random.nextInt(0, 500)
    } finally {
        println("random04_1 is cancelled.")
    }
}

suspend fun random04_2(): Int {
    delay(500L)
    throw IllegalStateException()
}
/*코드를 수행하다 보면 예외가 발생할 수 있습니다. 예외가 발생하면 위쪽의 코루틴 스코프와 아래쪽의 코루틴 스코프가 취소됩니다.*/
suspend fun doSomething() = coroutineScope {
    val value1 = async { random04_1() }
    val value2 = async { random04_2() }
    try {
        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    } finally {
        println("doSomething is cancelled.")
    }
}

fun main() = runBlocking {
    try {
        doSomething()
    } catch (e: IllegalStateException) {
        println("doSomething failed: $e")
    }
}

