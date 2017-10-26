package com.tutorial.learnlinuxpro.presentation.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kodeartisan.kotlintemplate.BaseApp
import com.tutorial.learnlinuxpro.presentation.di.component.ActivityComponent
import com.tutorial.learnlinuxpro.presentation.di.component.DaggerActivityComponent

/**
 * Created by kodeartisan on 12/10/17.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutId(): Int
    open fun initDependencies(){}
    open fun initWidget(){}
    open fun initVariables(savedInstanceState: Bundle?){}
    open fun initPresenter(){}
    open fun initListener(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        getActivityComponent()
        initDependencies()
        initPresenter()
        initWidget()
        initListener()
        initVariables(savedInstanceState)

    }


    fun getActivityComponent(): ActivityComponent {
         return DaggerActivityComponent.builder()
                 .applicationComponent(BaseApp.appComponent)
                 .build()
    }
    



}