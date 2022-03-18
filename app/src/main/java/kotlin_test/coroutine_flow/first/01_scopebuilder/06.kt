package kotlin_test.coroutine_flow.first.`01_scopebuilder`

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *1, 2, 3 순서대로 됨 런블록 딜레이 500 걸리고 , 첫번쨰 런처에서 1000 걸리고 1 -> 2- > 3
 * 딜레이 없으면 2-> 3-> 1
 * 여기서 알 수 있는 점은 단일 스레드를 사용해도 코루틴간의 서로 양보가 보장이 된다.
 * 상위 스코프는 하위 스코프를 끝까지 책임을 져줌
 */
fun main() = runBlocking{
    launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }
    launch {
        println("launch2 :${Thread.currentThread().name}")
        println("1!")
    }

    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L) // suspension point(중단점)
    println("2!")
}