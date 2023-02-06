package com.example.kotlinlearning.modules.collect.inter

import android.util.Log
import com.example.kotlinlearning.data_model.local.LocalRoomRequestManager
import com.example.kotlinlearning.database.Student

class CollectModelImpl: ICollectModule {


    override fun requestInsert(
        listener: ICollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().requestInert(*students)
        listener.showIUD(true)
    }

    override fun requestUpdate(
        listener: ICollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().requestUpdate(*students)
        listener.showIUD(true)
    }

    override fun requestDelete(
        listener: ICollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().requestDelete(*students)
        listener.showIUD(true)
    }

    override fun requestDeleteAll(listener: ICollectPresenter.OnCollectListener) {
        LocalRoomRequestManager.getInstance().requestDeleteAll()
        listener.showIUD(true)
    }

    override fun requestQueryAll(listener: ICollectPresenter.OnCollectResponseListener) {
        val result = LocalRoomRequestManager.getInstance().requestQueryAll()
        Log.d("TAG", "requestQueryAll")
        listener.showResultSuccess(result)
    }


}