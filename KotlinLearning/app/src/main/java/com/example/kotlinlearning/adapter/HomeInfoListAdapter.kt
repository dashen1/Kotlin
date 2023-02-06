package com.example.kotlinlearning.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlinlearning.R
import com.xiangxue.kotlinproject.entity.HomeDataResponse

class HomeInfoListAdapter private constructor(): BaseAdapter(){

    //数据
    private lateinit var mNews: List<HomeDataResponse.NewsListBean>
    private lateinit var context: Context

    constructor(context: Context, mNews: List<HomeDataResponse.NewsListBean>) : this() {
        this.context = context
        this.mNews = mNews
    }

    override fun getCount(): Int = mNews.size

    override fun getItem(position: Int): Any = mNews[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var viewHolder = ViewHolder

        var view: View? = null

        if (view == null) {
            view = View.inflate(this.context, R.layout.home_list_item, null)

            viewHolder = ViewHolder
            viewHolder.newsText = view.findViewById(R.id.news_text)
            viewHolder.newsDate = view.findViewById(R.id.news_date)
            view.tag = view.tag as ViewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }
        val news: HomeDataResponse.NewsListBean = mNews[position]
        viewHolder.newsText.text = news.title
        viewHolder.newsDate.text = news.create_time
        return view
    }

    object ViewHolder {
        lateinit var newsText: TextView
        lateinit var newsDate: TextView
    }

}