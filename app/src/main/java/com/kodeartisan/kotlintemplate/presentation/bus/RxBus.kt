package com.tutorial.learnlinuxpro.presentation.bus

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by kodeartisan on 19/10/17.
 */
object RxBus {

    private val bus = PublishSubject.create<Any>()

    fun send(event: Any) {
        bus.onNext(event)
    }

    fun hasObservers(): Boolean = bus.hasObservers()

    // Listen should return an Observable and not the publisher
    // Using ofType we filter only events that match that class type
    fun <T> listen(eventType: Class<T>): Observable<T> = bus.ofType(eventType)
}