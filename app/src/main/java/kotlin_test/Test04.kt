package kotlin_test



fun main() {
    reserveAlarm("일어나!!", Duration.seconds(2))
}

fun reserveAlarm(alarmMessage: String, durationInMillis: Duration) =
    println("${durationInMillis.millis} 초 후에 [$alarmMessage] 알람이 울립니다.")


//value class 는 래핑된 프로퍼티를 최적화 하는 방식임 컴파일 단계에서 객체 타입을 프로퍼티 타입으로 바꿔 사용
@JvmInline
value class Duration private constructor(
    val millis:Long
){
    companion object{
        fun millis(millis:Long) = Duration(millis)
        fun seconds(seconds: Long) = Duration(seconds * 1000)
    }
}