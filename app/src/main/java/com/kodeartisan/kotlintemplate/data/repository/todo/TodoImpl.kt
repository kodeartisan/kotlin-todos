package com.kodeartisan.kotlintemplate.data.repository.todo

import android.support.annotation.NonNull
import com.kodeartisan.kotlintemplate.data.entity.Todo
import com.kodeartisan.kotlintemplate.domain.repository.ITodoRepository
import com.tutorial.learnlinuxpro.data.source.local.room.AppDatabase
import com.tutorial.learnlinuxpro.data.utils.schedulers.BaseSchedulerProvider
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kodeartisan on 26/10/17.
 */
@Singleton
class TodoImpl @Inject constructor(@NonNull private val schedulerProvider: BaseSchedulerProvider, @NonNull private val appDatabase: AppDatabase): ITodoRepository {

    override fun getTodos(): Flowable<List<Todo>> {
        return appDatabase.exampleDao().getTodos().subscribeOn(schedulerProvider.multi())
    }
}