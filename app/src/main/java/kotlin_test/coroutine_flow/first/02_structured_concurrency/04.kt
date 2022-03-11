package kotlin_test.coroutine_flow.first.`02structured_concurrency`

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴은 협력적으로 동작하기 때문에 여러 코루틴을 만드는 것은 큰 비용이 들지 않음
 * 스레드는 10만개 만들면 뻗음
 */
suspend fun doOneTwoThree04() = coroutineScope {
    val job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }
    job.join()

    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }

    repeat(100_000) {
        launch {
            println("launch3: ${Thread.currentThread().name}")
            delay(500L)
            println("2!")
        }
    }
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree04()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}