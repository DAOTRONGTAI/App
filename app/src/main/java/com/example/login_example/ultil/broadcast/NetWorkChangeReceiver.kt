package com.example.login_example.ultil.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.login_example.ultil.AppEvent
import com.example.login_example.ultil.NetworkStatusUtil
import org.greenrobot.eventbus.EventBus

class NetWorkChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val status = context?.let { NetworkStatusUtil.getConnectivityStatusString(it) }

        if("android.net.conn.CONNECTIVITY_CHANGE".equals(intent?.action)){
            if (status == NetworkStatusUtil.NETWORK_STATUS_NOT_CONNECTED){
                Toast.makeText(context,"No Network Connected", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Network Connected", Toast.LENGTH_SHORT).show()
                EventBus.getDefault().post(AppEvent.NETWORK_CONNECTED)
            }
        }
    }
}