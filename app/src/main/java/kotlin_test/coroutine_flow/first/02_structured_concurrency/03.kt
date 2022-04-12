package kotlin_test.coroutine_flow.first.`02_structured_concurrency`

import kotlinx.coroutines.*

/**
 * launch는 Job객체를 반환하며 이를 통해 종료 시킬 수 있음
 */

//부모 스코프는 자식 스코프가 끝나기를 기다린다.
suspend fun doOneTwoThree() = coroutineScope {
    val job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L) //suspension point
        println("3!")
    }
    job.join() //suspension point 조인이 걸려있으면 계속 여기서 머뭄

    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }

    launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L) //suspension point
        println("2!")
    }
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}

