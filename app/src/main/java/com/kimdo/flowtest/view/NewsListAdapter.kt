package com.kimdo.flowtest.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kimdo.flowtest.databinding.ItemNewsArticleBinding
import com.kimdo.flowtest.model.NewsArticle

class NewsListAdapter : RecyclerView.Adapter< NewsListAdapter.NewsItemViewHolder>(){

    private val newsItems = arrayListOf<NewsArticle>()

    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    class NewsItemViewHolder(var binding: ItemNewsArticleBinding ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val inflater = LayoutInflater.from( parent.context)
        val binding = ItemNewsArticleBinding.inflate(inflater, parent, false)
        return NewsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val item = newsItems[position]
        holder.binding.newsAuthor.text = item.author
        holder.binding.newsTitle.text = item.title
        holder.binding.newsPublishedAt.text = item.publishedAt
        holder.binding.newsImage.loadImage( item.urlToImage)
    }

    override fun getItemCount() = newsItems.size
}