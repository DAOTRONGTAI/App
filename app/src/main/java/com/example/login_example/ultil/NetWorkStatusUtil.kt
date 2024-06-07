package com.example.login_example.ultil

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

//class NetWorkStatusUtil {
//    val TYPE_WIFI: Int = 1
//    val TYPE_MOBILE: Int = 2
//    val TYPE_NOT_CONNECTED: Int = 0
//    val NETWORK_STATUS_NOT_CONNECTED: Int = 0
//    val NETWORK_STATUS_WIFI: Int = 1
//    val NETWORK_STATUS_MOBILE: Int = 2
//
//
//    fun getConnectivityStatusString(context: Context) : Int {
//        val connect = NetWorkStatusUtil.getConnectivityStatus(context)
//
//        return TYPE_NOT_CONNECTED
//    }
//
//}

object NetworkStatusUtil {
    const val TYPE_WIFI = 1
    const val TYPE_MOBILE = 2
    const val TYPE_NOT_CONNECTED = 0
    const val NETWORK_STATUS_NOT_CONNECTED = 0
    const val NETWORK_STATUS_WIFI = 1
    const val NETWORK_STATUS_MOBILE = 2

    @Suppress("DEPRECATION")
    fun getConnectivityStatus(context: Context): Int {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI

            if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE
        }
        return TYPE_NOT_CONNECTED
    }

    fun getConnectivityStatusString(context: Context): Int {
        val conn = getConnectivityStatus(context)
        var status = 0
        if (conn == TYPE_WIFI) {
            status = NETWORK_STATUS_WIFI
        } else if (conn == TYPE_MOBILE) {
            status = NETWORK_STATUS_MOBILE
        }
        return status
    }

    @Suppress("DEPRECATION")
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}



