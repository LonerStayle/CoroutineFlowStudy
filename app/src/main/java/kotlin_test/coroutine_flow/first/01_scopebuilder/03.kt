package kotlin_test.coroutine_flow.first.`01_scopebuilder`

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *launch는 코루틴 빌더 입니다. 새로운 코루틴을 만들기 때문에 새로운 코루틴 스코프를 만들게 되고
 * launch는 "할 수 있다면 다른 코루틴 코드를 같이 수행" 시키는 코루틴 빌더 입니다.
 *
 * 둘다 메인 스레드를 사용하기 때문에 runBlocking 의 코드들이 메인스레드를 다 사용할 때까지 launch의 코드 블록을
 * 기다리는 것입니다.
 *
 */
fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")
        println("World!")
    }

    println("launch: ${Thread.currentThread().name}")
    println("Hello")
}