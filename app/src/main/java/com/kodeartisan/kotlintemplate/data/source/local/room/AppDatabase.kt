package com.tutorial.learnlinuxpro.data.source.local.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kodeartisan.kotlintemplate.data.entity.Todo

/**
 * Created by kodeartisan on 16/10/17.
 */
@Database(entities = arrayOf(Todo::class), version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun exampleDao(): TodoDao


}