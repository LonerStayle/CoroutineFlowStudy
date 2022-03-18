package kotlin_test

/** TEST01*/
val name: String? = "Martin"
val surname: String? = "Braun"
val fullName: String? get() = name?.let { "$it $surname" }
val fullName2: String? = name?.let { "$it $surname" }
/****/
fun main() {
    if (fullName2 != null) {
        println(fullName2.length)
    }
}