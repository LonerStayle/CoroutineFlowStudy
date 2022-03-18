package kotlin_test.coroutine_flow.first.`01_scopebuilder`

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 상위 스코프는 하위 스코프를 끝까지 책임을 져줌
 * 런블록킹은 하위 런처를 포함해서 다 동작이 끝낼때 까지 기다림
 * 상위를 캔슬하면 자식들도 모두 캔슬되는 특징이 있음
 */
fun main() {
    runBlocking{ // 계층적, 구조적
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
    print("4!")
}