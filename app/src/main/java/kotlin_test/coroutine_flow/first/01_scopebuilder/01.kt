package kotlin_test.coroutine_flow.first

import kotlinx.coroutines.runBlocking

/**
 * 코루틴를 만드는 함수를 코루틴 빌더라고 함 , runBlocking은 코루틴을 만들고 블록 수행이 끝날때까지
 * 다음의 코드를 수행하지 못하게 막음*/
/**
 * this를 수행하면 코루틴이 수신객체인 것을 알 수 있습니다.
 * 마치 코드블록을 코루틴 확장한듯한 개념.
 *
 * BlockingCoroutine은 CoroutineScope의 자식 입니다. 코루틴을 쓰는 모든곳에는 코루틴 스코프입니다.
식*/
fun main(){
    runBlocking{
        println(this)
        println(Thread.currentThread().name)
        print("Hello")
    }
}

