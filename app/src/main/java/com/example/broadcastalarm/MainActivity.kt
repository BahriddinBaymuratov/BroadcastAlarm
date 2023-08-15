package com.example.broadcastalarm

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.broadcastalarm.broadcast.MyBroadcastReceiver
import com.example.broadcastalarm.util.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var myBroadcastReceiver: MyBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myBroadcastReceiver = MyBroadcastReceiver()

        val intentFilter = IntentFilter(Constants.ACTION_CONNECTION)
        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) { }

            override fun onFinish() {
                registerReceiver(myBroadcastReceiver, intentFilter)
            }
        }.start()
    }

//    override fun onPause() {
//        super.onPause()
//        unregisterReceiver(myBroadcastReceiver)
//    }
}