package kotlin_test.coroutine_flow.first

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *딜레이는 해당 코루틴 쓰레드만 잠들고 다른 코루틴에 쓰레드를 양보를 하는 반면,
 * 쓰레드 슬립은 양보하지 않음,
 * 쓰레드 슬립은 운영체제에게 휴식을 요청하지만 다른 코드에게 해당 쓰레드를 넘겨주지 않음
 */
fun main() = runBlocking{
    launch {
        println("launch: ${Thread.currentThread().name}")
        println("World!")
    }
    println("runBlocking: ${Thread.currentThread().name}")
    Thread.sleep(500)
    println("Hello!")
}