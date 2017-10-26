package com.tutorial.learnlinuxpro.presentation.di.module

import android.support.annotation.NonNull
import com.kodeartisan.kotlintemplate.domain.repository.ITodoRepository
import com.kodeartisan.kotlintemplate.presentation.ui.todo.TodoContract
import com.kodeartisan.kotlintemplate.presentation.ui.todo.TodoPresenter
import com.tutorial.learnlinuxpro.data.utils.schedulers.BaseSchedulerProvider
import com.tutorial.learnlinuxpro.presentation.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by kodeartisan on 12/10/17.
 */
@Module
class PresenterModule {

    @ActivityScope
    @Provides
    fun examplePresenter(@NonNull baseSchedulerProvider: BaseSchedulerProvider, @NonNull iExampleRepository: ITodoRepository): TodoContract.Presenter<TodoContract.View> = TodoPresenter(baseSchedulerProvider, iExampleRepository)

}