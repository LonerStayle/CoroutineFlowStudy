package kotlin_test.coroutine_flow.first.`03_cancel_timeout`

import kotlinx.coroutines.*

/**
 * withTimeoutOrNull 로 타임아웃에 따라 null 리턴을 할 수 있음
 */
suspend fun doCount08() = coroutineScope {
    val job1 = launch(Dispatchers.Default) {
        var i = 1
        var nextTime = System.currentTimeMillis() + 100L

        while (i <= 10 && isActive) {
            val currentTime = System.currentTimeMillis()
            if (currentTime >= nextTime) {
                println(i)
                nextTime = currentTime + 100L
                i++
            }
        }
    }
}

fun main() = runBlocking {
    val result = withTimeoutOrNull(500L) {
        doCount08()
        true
    } ?: false
    println(result)
}