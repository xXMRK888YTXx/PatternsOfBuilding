

data class Coffee private constructor(
    val isHaveSugar:Boolean,
    val isHaveMilk:Boolean,
    val isHaveSyrup:Boolean
) {
    class Builder {

        private var isHaveSugar:Boolean = false
        private var isHaveMilk:Boolean = false
        private var isHaveSyrup:Boolean = false

        private var isBuilderUsed:Boolean = false

        fun addSugar() : Builder {
            isHaveSugar = true

            return this
        }

        fun addMilk() : Builder {
            isHaveMilk = true

            return this
        }

        fun addSyrup() : Builder {
            isHaveSyrup = false

            return this
        }

        fun build() : Coffee {
            check(!isBuilderUsed) { "Builder already used" }

            isBuilderUsed = true

            return Coffee(isHaveSugar, isHaveMilk, isHaveSyrup)
        }


    }
}

fun main() {
    val coffee = Coffee.Builder().apply {
        addMilk()
        addSugar()
    }.build()

    println(coffee)
}