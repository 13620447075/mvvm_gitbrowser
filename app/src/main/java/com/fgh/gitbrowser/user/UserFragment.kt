package com.fgh.gitbrowser.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.fgh.gitbrowser.R
import com.fgh.gitbrowser.binding.FragmentDataBindingComponent
import com.fgh.gitbrowser.databinding.FragmentUserBinding
import com.fgh.gitbrowser.di.Injectable
import com.fgh.gitbrowser.util.call.autoCleared
import javax.inject.Inject

class UserFragment : Fragment(), Injectable {

    //fragment需要
    private val dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    private var binding by autoCleared<FragmentUserBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentUserBinding>(
            inflater,
            R.layout.fragment_user,
            container,
            false,
            dataBindingComponent
        )
        binding = dataBinding
        return dataBinding.root
    }


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: UserViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //更新视图
        viewModel.setUser("open-android")
        Log.e("-----", "fragment")
        binding.user = viewModel.user
        binding.lifecycleOwner = viewLifecycleOwner
    }

}