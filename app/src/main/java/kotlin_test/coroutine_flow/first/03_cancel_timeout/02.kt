package kotlin_test.coroutine_flow.first.`03_cancel_timeout`

import kotlinx.coroutines.*

/**
 * 아래 예제는 취소가 불가능한 Job
 */
suspend fun doCount() = coroutineScope {
    val job1 = launch(Dispatchers.Default) {
        var i = 1
        var nextTime = System.currentTimeMillis() + 100L
        while (i <= 10) {
            val currentTime = System.currentTimeMillis()
            if (currentTime >= nextTime) {
                println(i)
                nextTime = currentTime + 100L
                i++
            }
        }
    }
    delay(200L)
    job1.cancel()
    println("doCount Done!")
}


fun main() = runBlocking {
    doCount()
}

