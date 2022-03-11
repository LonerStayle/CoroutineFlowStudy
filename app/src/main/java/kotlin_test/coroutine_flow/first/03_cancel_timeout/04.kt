package kotlin_test.coroutine_flow.first.`03_cancel_timeout`

import kotlinx.coroutines.*

/**
 * cancel and join
 */
suspend fun doCount04() = coroutineScope {
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

    delay(200L)
    job1.cancelAndJoin()
    println("doCount04 Done!")
}

fun main() = runBlocking {
    doCount04()
}