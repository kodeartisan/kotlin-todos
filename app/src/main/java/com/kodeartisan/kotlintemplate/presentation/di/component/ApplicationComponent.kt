package com.tutorial.learnlinuxpro.presentation.di.component

import com.kodeartisan.kotlintemplate.domain.repository.ITodoRepository
import com.tutorial.learnlinuxpro.data.source.local.room.AppDatabase
import com.tutorial.learnlinuxpro.data.utils.schedulers.BaseSchedulerProvider
import com.tutorial.learnlinuxpro.presentation.di.module.ApplicationModule
import com.tutorial.learnlinuxpro.presentation.di.module.DataModule
import com.tutorial.learnlinuxpro.presentation.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by kodeartisan on 12/10/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class, DataModule::class))
interface ApplicationComponent {

    fun getSchedulerProvider(): BaseSchedulerProvider
    fun getAppDatabase(): AppDatabase
    fun getIExampleRepository(): ITodoRepository


}