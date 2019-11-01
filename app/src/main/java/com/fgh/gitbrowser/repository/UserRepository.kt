package com.fgh.gitbrowser.repository

import androidx.lifecycle.LiveData
import com.fgh.gitbrowser.AppExecutors
import com.fgh.gitbrowser.api.ApiResponse
import com.fgh.gitbrowser.api.ApiService
import com.fgh.gitbrowser.db.UserDao
import com.fgh.gitbrowser.vo.Resource
import com.fgh.gitbrowser.vo.User
import javax.inject.Inject

class UserRepository
@Inject
constructor(
    val dao: UserDao,
    val service: ApiService,
    val appExecutors: AppExecutors
) {

    fun loadUser(login: String): LiveData<Resource<User>> {

        return object : NetworkBoundResource<User, User>(appExecutors = appExecutors) {
            override fun shouldFetch(data: User?): Boolean = data == null

            override fun loadFromDb(): LiveData<User> {
                return dao.findByLogin(login)
            }

            override fun createCall(): LiveData<ApiResponse<User>> {
                return service.getUser(login)
            }

            override fun saveCallResult(item: User) {
                dao.insert(item)
            }
        }.asLiveData()

    }

}