package com.aligkts.campaignsapp.common.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.aligkts.campaignsapp.common.Resource
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.joda.time.DateTime
import org.joda.time.Period
import org.joda.time.PeriodType
import org.joda.time.format.PeriodFormatterBuilder
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter


/**
 * Created by Ali Göktaş on 01,February,2020
 */


fun <T : ViewDataBinding> ViewGroup?.inflate(@LayoutRes layoutId: Int, attachToParent: Boolean = true): T {
    return DataBindingUtil.inflate(
        LayoutInflater.from(this!!.context),
        layoutId,
        this,
        attachToParent
    )
}

fun <T> applyLoading(): ObservableTransformer<Resource<T>, Resource<T>> =
    ObservableTransformer { upstream ->
        Observable.just(Resource.loading<T>()).concatWith(upstream)
    }

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer {
        it?.let(observer)
    })
}

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}

fun Any?.runIfNull(block: () -> Unit) {
    if (this == null) block()
}

fun String?.calculateRemainingTime(): String? { // date format
    if (!this.validateDateFormatISO8601()) return null
    val expirationDate = OffsetDateTime.parse(this, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    val startDate = DateTime.now()
    val endDate = DateTime(
        expirationDate.year,
        expirationDate.monthValue,
        expirationDate.dayOfMonth,
        expirationDate.hour,
        expirationDate.minute
    )
    if (endDate.isBefore(startDate)) return "Expired"
    val period = Period(startDate, endDate, PeriodType.dayTime())

    val formatter = PeriodFormatterBuilder()
        .appendDays().appendSuffix(" day ", " days ")
        .appendHours().appendSuffix(" hour ", " hours ")
        .appendMinutes().appendSuffix(" minute ", " minutes ")
        .appendSeconds().appendSuffix(" second ", " seconds ")
        .toFormatter()

    return formatter.print(period)
}

fun String?.validateDateFormatISO8601() : Boolean {
    val formatted = this?.matches(Regex("^(?:[1-9]\\d{3}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[1-9]\\d(?:0[48]|[2468][048]|[13579][26])|(?:[2468][048]|[13579][26])00)-02-29)T(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(?:Z|[+-][01]\\d:[0-5]\\d)\$"))
    formatted?.let {
        return it
    }
    return false
}