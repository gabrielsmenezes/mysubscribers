package com.example.mysubscribers.ui.subscriberlist

import androidx.lifecycle.ViewModel
import com.example.mysubscribers.repository.SubscriberRepository

class SubscriberListViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val allSubscribersEvent = repository.getAllSubscribers()

}