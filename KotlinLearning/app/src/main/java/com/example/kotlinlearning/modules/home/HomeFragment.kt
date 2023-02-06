package com.example.kotlinlearning.modules.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kotlinlearning.R
import com.example.kotlinlearning.adapter.HomeInfoListAdapter
import com.example.kotlinlearning.config.Flag
import com.example.kotlinlearning.data_model.local.request.NetworkRequestData
import com.example.kotlinlearning.data_model.local.request.RequestAPI
import com.google.gson.Gson
import com.xiangxue.kotlinproject.entity.HomeDataResponse
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "HomeFragment", Toast.LENGTH_SHORT).show()
        val root: View ?= inflater.inflate(R.layout.fragment_home, container, false)
        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    init {
        setHasOptionsMenu(true);
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.personal_menu, menu)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestHomeData()
    }

    private fun requestHomeData() {
        RequestAPI.instanceRequestAction(Flag.SERVER_URL, "1", object : NetworkRequestData() {
            override fun requestError(info: String) {
                showError(info)
            }

            override fun requestSuccess(result: Response) {
                try {
                    val resultData = result.body()?.string().toString()
                    val gson = Gson()
                    val homeDataResponse = gson.fromJson(resultData, HomeDataResponse::class.java)
                    showSuccess(homeDataResponse)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

        })
    }

    private fun showSuccess(result: HomeDataResponse) {
        text_home.text = "welcome to home page"
        home_listView.adapter = HomeInfoListAdapter(requireContext(), result.data.news_list)
        //两张图片的显示
        Glide.with(iv_top).load(result.data.company_list[0].image).into(iv_top)
        Glide.with(iv_bottom).load(result.data.company_list[0].image).into(iv_bottom)

    }

    private fun showError(info: String) {

    }
}