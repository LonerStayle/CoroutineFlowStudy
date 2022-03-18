package kotlin_test.coroutine_flow.first.`01_scopebuilder`

import kotlinx.coroutines.runBlocking

/**
 * 코루틴 스코프는 코루틴을 제대로 처리하기 위한 정보, 코루틴 컨텍스트를 가지고 있습니다.
 * 런블록이 수신객체를 제공해주고 런블록의 수신객체는 코루틴빌더 이기 때문에 coroutineContext를 바로 사용할 수 있음
 */
fun main() = runBlocking{
    println(coroutineContext)
    println(Thread.currentThread().name)
}