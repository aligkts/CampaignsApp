package com.aligkts.campaignsapp.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ali Göktaş on 01,February,2020
 */
open class RxAwareViewModel : ViewModel() {
    val disposable = CompositeDisposable()

    override fun onCleared() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
        super.onCleared()
    }
}