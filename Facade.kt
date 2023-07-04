


interface UserManager {

    fun getUser() : Any
}

interface ApiManager {
    fun getUser() : Any
}

interface CacheManager {

    fun addUser(any: Any)

    fun getUser() : Any?
}

class UserManagerImpl(
    private val apiManager: ApiManager,
    private val cacheManager: CacheManager
) : UserManager {

    override fun getUser(): Any {
        val cashedUser = cacheManager.getUser()

        if(cashedUser != null) return cashedUser

        return apiManager.getUser().apply {
            cacheManager.addUser(this)
        }
    }

}