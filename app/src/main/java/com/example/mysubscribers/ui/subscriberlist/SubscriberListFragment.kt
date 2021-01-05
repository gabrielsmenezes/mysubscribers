package com.example.mysubscribers.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mysubscribers.R
import com.example.mysubscribers.data.db.entity.SubscriberEntity
import kotlinx.android.synthetic.main.subscriber_list_fragment.*

class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {
    private lateinit var viewModel: SubscriberListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val subscriberListAdapter = SubscriberListAdapter(listOf(
            SubscriberEntity(name = "Cristiano Palmucci", email = "email@email.com"),
            SubscriberEntity(name = "Cristiano Ronaldo", email = "email@email.com"),
            SubscriberEntity(name = "Ronaldo Messi", email = "email@email.com"),
        ))

        recycler_subscribers.run {
            setHasFixedSize(true)
            adapter = subscriberListAdapter
        }

    }
}