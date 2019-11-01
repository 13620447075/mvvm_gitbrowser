package com.fgh.gitbrowser.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fgh.gitbrowser.repository.UserRepository
import com.fgh.gitbrowser.util.call.AbsentLiveData
import com.fgh.gitbrowser.vo.Resource
import com.fgh.gitbrowser.vo.User
import javax.inject.Inject

/**
 * 需要添加进ViewModelModule
 */
class UserViewModel
//注入repository
@Inject
constructor(userRepository:UserRepository): ViewModel() {

    private val _login = MutableLiveData<String>()

    fun setUser(login:String){
        _login.value = login
    }

      val user :LiveData<Resource<User>> = Transformations.switchMap(_login){login->
        if (login == null) {
            Log.e("-----model", "-???")
            AbsentLiveData.create()
        } else {
            Log.e("-----model 请求网络", "-" + userRepository.loadUser(login))
            userRepository.loadUser(login)
        }
    }

}