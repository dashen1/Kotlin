package com.example.kotlinlearning.modules.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinlearning.R
import com.example.kotlinlearning.adapter.CollectAdapter
import com.example.kotlinlearning.base.BaseFragment
import com.example.kotlinlearning.database.Student
import com.example.kotlinlearning.modules.collect.inter.CollectPresenterImpl
import com.example.kotlinlearning.modules.collect.inter.ICollectPresenter
import com.example.kotlinlearning.modules.collect.inter.ICollectView
import kotlinx.android.synthetic.main.fragment_collect.*

class CollectFragment : BaseFragment<ICollectPresenter>(), ICollectView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "collection", Toast.LENGTH_SHORT).show()
        val root: View ?= inflater.inflate(R.layout.fragment_collect, container, false)
        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    // 类似java的构造代码块
    init {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //　TODO Insert　动作
        addData.setOnClickListener {
            val names = arrayOf<String> (
                "乔峰",
                "段誉",
                "虚竹",
                "慕容复",
                "张三",
                "李四",
                "王五",
                "赵六",
                "初七",
                "杜子腾",
                "王小二",
                "李大奇"
            )
            val ages = arrayOf<Int> (
                43,
                24,
                19,
                83,
                64,
                21,
                56,
                32,
                17,
                32,
                45,
                14
            )
            for (index in names.indices) {
                val stu = Student(names[index], ages[index])
                p.requestInert(stu)
            }
        }

        clearData.setOnClickListener {
            p.requestDeleteAll()
        }
    }

    override fun getPresenter(): ICollectPresenter = CollectPresenterImpl(this)

    override fun createFragment() {
        p.requestDeleteAll()
    }

    override fun recycle() {
        p.unAttachView()
    }

    override fun showResultSuccess(result: List<Student>?) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = CollectAdapter()
        if (null != result) {
            adapter.allStudents = result
        }
        recyclerView.adapter = adapter
    }

    override fun showIUD(result: Boolean) {
        if (result) p.requestQueryAll()
    }

}