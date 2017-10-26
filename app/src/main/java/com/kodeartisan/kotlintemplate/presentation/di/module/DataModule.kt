package com.tutorial.learnlinuxpro.presentation.di.module

import com.kodeartisan.kotlintemplate.data.repository.todo.TodoImpl
import com.kodeartisan.kotlintemplate.domain.repository.ITodoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by kodeartisan on 12/10/17.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    fun exampleRepository(exampleImpl: TodoImpl): ITodoRepository {
        return exampleImpl
    }
}