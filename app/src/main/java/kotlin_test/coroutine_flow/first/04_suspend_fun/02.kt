package kotlin_test.coroutine_flow.first.`04_suspend_fun`

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun random1(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun random2(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

/*수행 결과를 보면 getRandom1과 getRandom2를 같이 수행해서 경과시간이 거의 반으로 줄어들었습니다.*/

/*많은 다른 언어들이 async, await 키워드를 가지고 있는데 그것과는 비슷하게 보이지만 조금 다릅니다.*/

/* 코틀린은 suspend 함수를 호출하기 위해 어떤 키워드도 필요하지 않습니다.
 코틀린의 suspend가 다른 언어에서 async와 같다고 보시면 됩니다. */

/*async, await 짝을 맞추는 것은 Microsoft .net C#의 영향으로 일반화되었는데 어떠한 키워드를 붙이지 않는
 Go언어의 양향을 받아 가능한 제거하려 노력했다고 합니다.*/

/* 그럼에도 불구하고 Java언어와의 호환성 때문에 suspend(async) 키워드는 버릴 수 없었습니다.*/

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async { random1() }
        val value2 = async { random2() }
        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    }
    println(elapsedTime)
}

