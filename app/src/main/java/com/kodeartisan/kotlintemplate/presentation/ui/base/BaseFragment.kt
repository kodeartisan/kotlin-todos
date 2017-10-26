package com.tutorial.learnlinuxpro.presentation.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by kodeartisan on 18/10/17.
 */
abstract class BaseFragment: Fragment() {

    protected lateinit var mInflater: LayoutInflater
    protected lateinit var mActivity: AppCompatActivity
    protected lateinit var mRootView: View

    abstract fun getLayoutId(): Int
    open fun initDependencies(){}
    open fun initWidget(){}
    open fun initVariables(savedInstanceState: Bundle?){}
    open fun initPresenter(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDependencies()
        initPresenter()
        initVariables(savedInstanceState)
        initWidget()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater!!.inflate(getLayoutId(), container, false)
        mActivity = activity as AppCompatActivity
        mInflater = inflater

        return mRootView
    }

    private fun getSupportActivity(): FragmentActivity {
        return super.getActivity()
    }


}