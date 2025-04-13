package com.android.oauth2_login_custom_tab

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.oauth2_login_custom_tab.encrypt.EncryptManager
import java.util.Locale
import java.util.UUID

class MainActivity : AppCompatActivity() {
    val pw = UUID.randomUUID().toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // encrypt 수행
        EncryptManager(pw)
    }
}
