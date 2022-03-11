package kotlin_test

import java.lang.NullPointerException

fun main() {
    takeDog(A() as Dog)
    takeDog(Puppy())
    takeDog(Hound())
    //에러
//    takeDog(B())
}

open class A
open class B
open class Dog : A()
class Puppy : Dog()
class Hound : Dog()

fun takeDog(dog: Dog) {}


class Box<out T> {
    private var value: T? = null

    // private 안하면 오류남
    private fun set(value: T) {
        this.value = value
    }
    fun get(): T = value?:throw NullPointerException("value is Null")
}