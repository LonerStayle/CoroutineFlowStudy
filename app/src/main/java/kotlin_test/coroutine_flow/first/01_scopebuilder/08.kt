package kotlin_test.coroutine_flow.first.`01_scopebuilder`

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * delay 나 launch 와 같은 코루틴 함수를 사용하고 싶으면 suspend 를 사용할 것
 */
suspend fun doThree(){
    println("launch1: ${Thread.currentThread().name}")
    delay(1000L)
    println("3!")
}

suspend fun doOne(){
    println("launch1: ${Thread.currentThread().name}")
    println("1!")
}
suspend fun doTwo(){
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("2!")
}

// runBlocking<T> 로 타입을 리턴 할 수도 있음
fun main()= runBlocking {
    launch {
        doThree()
    }
    launch {
        doOne()
    }
    doTwo()
}
