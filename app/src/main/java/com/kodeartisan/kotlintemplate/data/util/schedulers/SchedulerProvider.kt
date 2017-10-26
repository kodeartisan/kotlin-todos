package com.tutorial.learnlinuxpro.data.utils.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by kodeartisan on 12/10/17.
 */
class SchedulerProvider : BaseSchedulerProvider {

    override fun computation(): Scheduler {
         return Schedulers.computation()
    }

    override fun multi(): Scheduler {
        return Schedulers.newThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}