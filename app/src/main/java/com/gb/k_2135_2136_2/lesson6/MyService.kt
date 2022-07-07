package com.gb.k_2135_2136_2.lesson6

import android.app.IntentService
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager


const val BUNDLE_KEY = "key"
class MyService:IntentService("") {

    override fun onHandleIntent(intent: Intent?) {
        Log.d("@@@"," MyService ")
        intent?.let {
            it.getStringExtra(BUNDLE_KEY)
            Log.d("@@@"," MyService ${it.getStringExtra(BUNDLE_KEY)}")
            Log.d("@@@"," onHandleIntent ${Thread.currentThread()}")
            LocalBroadcastManager.getInstance(this).sendBroadcast(Intent().apply {
                action = "answer"
            })
        }
    }

    override fun onCreate() {
        super.onCreate()
    }


    //вызывается, когда компонент программы запрашивает запуск сервиса посредством метода startService().
    // Затем сервис будет работать неограниченное время. Для остановки такого сервиса используется stopSelf()
    // или stopService(). Для сервиса, реализованного только для привязки, метод onStartCommand()
    // переопределять необязательно. Метод возвращает целое число, которое определяет поведение
    // системы при уничтожении сервиса. Возврат должен быть одной из констант:
    //a.   START_STICKY — если система уничтожает сервис, ОС попытается пересоздать его, например, при пересоздании активити;
    //b.   START_NOT_STICKY — система не пересоздаст сервис;
    //c.   START_REDELIER_INTENT — система попытается перезапустить сервис с последним интентом, подходит для операций по закачке данных из интернета.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}