package com.example.coffee4n

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Khởi tạo toàn cục nếu cần (DI, Logging, v.v.)
    }
}