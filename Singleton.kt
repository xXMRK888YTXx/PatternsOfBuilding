
interface Singleton<out T> {
    fun get() : T

}

class Sun

object DefaultSingleton : Singleton<Sun> {

    private var instants:Sun? = null

    override fun get(): Sun {
        if(instants == null) {
            instants = Sun()
        }

        return instants!!
    }

}

object LazyDelegateSingleton : Singleton<Sun> {

    private val instants by lazy {
        Sun()
    }

    override fun get(): Sun {
        return instants
    }

}

fun main() {
    println("DefaultSingleton")

    val i1 = DefaultSingleton.get()
    val i2 = DefaultSingleton.get()

    println(i1 === i2)

    val i3 = LazyDelegateSingleton.get()
    val i4 = LazyDelegateSingleton.get()

    println(i3 === i4)
}