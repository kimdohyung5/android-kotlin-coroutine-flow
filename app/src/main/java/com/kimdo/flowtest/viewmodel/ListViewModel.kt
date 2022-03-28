package com.kimdo.flowtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kimdo.flowtest.model.NewsRepository

class ListViewModel : ViewModel() {
    var newsArticles = NewsRepository().getNewsArticles().asLiveData()
}