package kotlin_test.coroutine_flow.first.`01_scopebuilder`

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
/**
 * 딜레이 함수
 * 중단점 서스펜드 포인트. 딜레이 동안 잠이듬
 * 아래는 한개의 스레드에서 사용중임
 * 서스펜드 포인트를 두면서 이렇게 코루틴 간에 협력이 가능해짐
 */
fun main() = runBlocking{
     launch {
         println("launch: ${Thread.currentThread().name}")
         delay(100L)
         println("World!")
     }
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("Hello")
}