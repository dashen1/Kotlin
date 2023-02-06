package com.example.kotlinlearning.modules.collect.inter

import com.example.kotlinlearning.database.Student

class CollectPresenterImpl(var collectView: ICollectView?) : ICollectPresenter,
    ICollectPresenter.OnCollectResponseListener, ICollectPresenter.OnCollectListener
{

    private val model: ICollectModule = CollectModelImpl()

    override fun requestInert(vararg student: Student) {
        model.requestInsert(this, *student)
    }

    override fun requestUpdate(vararg student: Student) {
        model.requestUpdate(this, *student)
    }

    override fun requestDelete(vararg student: Student) {
        model.requestDelete(this, *student)
    }

    override fun requestDeleteAll() {
        model.requestDeleteAll(this)
    }

    override fun requestQueryAll() {
        model.requestQueryAll(this)
    }

    override fun unAttachView() {
        collectView = null
    }

    override fun showResultSuccess(result: List<Student>?) {
        collectView?.showResultSuccess(result)
    }

    override fun showIUD(iudResult: Boolean) {
        collectView?.showIUD(iudResult)
    }
}