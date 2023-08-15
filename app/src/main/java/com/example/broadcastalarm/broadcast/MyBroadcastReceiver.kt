package com.example.broadcastalarm.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.broadcastalarm.MainActivity
import com.example.broadcastalarm.NoInternetActivity
import com.example.broadcastalarm.util.NetworkUtils

class MyBroadcastReceiver : BroadcastReceiver() {
    private val TAG = "MyBroadcastReceiver"
    override fun onReceive(context: Context?, intent: Intent?) {
        if (!hasInternet(context!!)) {
            Toast.makeText(context, "No internet available", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, NoInternetActivity::class.java))
        } else {
            Toast.makeText(context, "Internet available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun hasInternet(context: Context): Boolean {
        val networkUtils = NetworkUtils(context)
        return networkUtils.isNetworkConnected()
    }
}