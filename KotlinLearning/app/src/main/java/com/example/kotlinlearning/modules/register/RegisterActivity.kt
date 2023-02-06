package com.example.kotlinlearning.modules.register

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.kotlinlearning.R
import com.example.kotlinlearning.base.BaseActivity
import com.example.kotlinlearning.entity.LoginRegisterResponse
import com.example.kotlinlearning.modules.register.inter.RegisterPresenter
import com.example.kotlinlearning.modules.register.inter.RegisterView
import kotlinx.android.synthetic.main.activity_user_login.*

class RegisterActivity : BaseActivity<RegisterPresenter>(), RegisterView {
    private val TAG: String = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        //val APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java);
        user_login_bt.setOnClickListener(onClickLister)
    }

    private val onClickLister = View.OnClickListener { view ->
        // id = 内部根据=判断你是getId还是setId
        when(view.id) {
            R.id.user_register_bt -> {
                val userName = user_phone_et.text.toString()
                val userPwd = user_password_et.text.toString()
                Log.d(TAG,"userName:$userName, userPwd:$userPwd")
                presenter.registerAction(this@RegisterActivity, userName, userPwd, userPwd)
            }
        }
    }

    override fun registerSuccess(loginRegisterBean: LoginRegisterResponse?) {
        Toast.makeText(this@RegisterActivity, "register success!", Toast.LENGTH_SHORT).show()
    }

    override fun registerFailure(errMsg: String?) {
        Toast.makeText(this@RegisterActivity, "register fail!", Toast.LENGTH_SHORT).show()
    }

    override fun createP(): RegisterPresenter = RegisterPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }
}