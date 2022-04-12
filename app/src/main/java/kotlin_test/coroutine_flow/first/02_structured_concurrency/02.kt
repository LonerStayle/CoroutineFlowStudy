package kotlin_test.coroutine_flow.first.`02_structured_concurrency`

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴 스코프를 만드는 다른 방법은 스코프 빌더를 이용하는 것
 * 코루틴 스코프는 오로지 코루틴 빌더를 호출하기 위함임
 */
suspend fun doOneTowThree() = coroutineScope {
    launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }
    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }
    launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }
    println("4!")
}

//런블록은 현재 쓰레드를 멈추지만 , 코루틴 스코프는 멈추지 않는다.
fun main() = runBlocking {
    doOneTowThree()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}

