package com.barry.practicetogether.model.utils

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


fun <T> ioMain(): ObservableTransformer<T, T>? {
    return ObservableTransformer { upstream: Observable<T> ->
        upstream
            .throttleFirst(3, TimeUnit.SECONDS)
            //.retryWhen(new RetryWithDelay(3, 4000))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}