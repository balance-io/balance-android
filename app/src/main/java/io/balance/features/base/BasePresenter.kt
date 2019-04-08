package io.balance.features.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import rx.Subscription

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
open class BasePresenter<T : MvpView> : Presenter<T> {

    var mvpView: T? = null
        private set
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    private val isViewAttached: Boolean
        get() = mvpView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    fun addSubscription(subs: Disposable) {
        compositeDisposable.add(subs)
    }

    protected fun Disposable.bindToLifecycle() = apply {
        compositeDisposable.add(this)
    }

    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")

}

