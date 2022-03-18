package kotlin_test.coroutine_flow.first.`03_cancel_timeout`

import kotlinx.coroutines.*

/**
 * 일정 시간 끝난 후에 종료하고 싶다면 withTimeout를 사용
 * 취소 되면 TimeoutCancellationException 발생
 */
suspend fun doCount07() = coroutineScope {
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
    withTimeout(500L) {
        doCount07()
    }
}