package com.example.kotlinlearning.modules.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.kotlinlearning.MainActivity
import com.example.kotlinlearning.R
import com.example.kotlinlearning.base.BaseActivity
import com.example.kotlinlearning.entity.LoginRegisterResponse
import com.example.kotlinlearning.modules.login.inter.ILoginPresenter
import com.example.kotlinlearning.modules.login.inter.ILoginView
import com.example.kotlinlearning.modules.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_user_login.*
import kotlinx.android.synthetic.main.fragment_personal.*

//ctr +alt+o 删除无用引用包
class ILoginActivity : BaseActivity<ILoginPresenter>(), ILoginView{
    private val TAG: String = "LoginActivity"

    lateinit var p: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        //val APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java);
        user_login_bt.setOnClickListener(onClickLister)
        user_login_tv.setOnClickListener{
            val intent = Intent(this@ILoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private val onClickLister = View.OnClickListener { view ->
        // id = 内部根据=判断你是getId还是setId
        when(view.id) {
            R.id.user_login_bt -> {
                val userName = user_phone_et.text.toString()
                val userPwd = user_password_et.text.toString()
                Log.d(TAG,"userName:$userName, userPwd:$userPwd")
                presenter.loginAction(this, userName, userPwd)
            }
        }
    }

    override fun loginSuccess(loginRegisterBean: LoginRegisterResponse?) {
        Toast.makeText(this@ILoginActivity, "login success!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@ILoginActivity, MainActivity::class.java)
        startActivity(intent)
    }

    override fun loginFailure(errMsg: String?) {
        Toast.makeText(this@ILoginActivity, "login fail!", Toast.LENGTH_SHORT).show()
    }

    override fun createP(): ILoginPresenter = ILoginPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }
}