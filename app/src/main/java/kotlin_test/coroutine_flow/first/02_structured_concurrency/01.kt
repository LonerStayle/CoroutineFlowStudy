package kotlin_test.coroutine_flow.first.`02_structured_concurrency`

import kotlinx.coroutines.runBlocking


/**
 * 서스펜스, 런치는 코루틴안에서만 사용할 수 있음
 * suspend fun과 코루틴은 다른것임
 * suspend fun은 잠들수만 있다는것을 말함
 *
 */
fun main()= runBlocking {

}

//오류 뜸 코루틴 빌더는 코루틴 스코프내에서만 호출해야함
//suspend fun doOneTwoThree(){
//    launch{ this : 가 코루틴임 리시버 임
//    }
//}
