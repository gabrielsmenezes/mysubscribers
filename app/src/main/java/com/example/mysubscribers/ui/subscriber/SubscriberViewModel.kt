package com.example.mysubscribers.ui.subscriber

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysubscribers.R
import com.example.mysubscribers.repository.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    private val _subscriberStateEventData = MutableLiveData<SubscriberState>()
    val subscriberStateEventData: LiveData<SubscriberState> get() = _subscriberStateEventData

    private val _messageStateEventData = MutableLiveData<Int>()
    val messageStateEventData: LiveData<Int> get() = _messageStateEventData

    fun addSubscriber(name: String, email: String) = viewModelScope.launch {
        try {
            val id = repository.insertSubscriber(name, email)
            if (id > 0) {
                _subscriberStateEventData.value = SubscriberState.Inserted
                _messageStateEventData.value = R.string.subscriber_inserted_successfully
            }
        } catch (ex: Exception) {
            _messageStateEventData.value = R.string.subscriber_error_to_insert
            Log.e(TAG, ex.toString())
        }
    }

    sealed class SubscriberState {
        object Inserted : SubscriberState()
    }

    companion object {
        private val TAG = SubscriberViewModel::class.java.simpleName
    }

}