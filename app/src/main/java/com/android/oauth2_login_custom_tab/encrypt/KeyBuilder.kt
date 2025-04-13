package com.android.oauth2_login_custom_tab.encrypt

import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import javax.crypto.SecretKeyFactory

class KeyBuilder(val pw :String) {
    val key = (pw + SALT).encodeToByteArray()

    init {
        current(4)
        current(5)
        current(7)
        kdf(4)
        kdf(5)
    }

    // 기존 키 생성 방식
    private fun current(count : Int){
        val md = MessageDigest.getInstance("SHA-256")
        var currentKey = key
        repeat(count){
            currentKey = md.digest(key)
        }
        val key = SecretKeySpec(currentKey,"AES")
        logKey("currentKey",key)
    }


    //PBKDF2 : Password-Based Key Derivation Function'
    private fun kdf(count : Int){
        val keySpec = PBEKeySpec(pw.toCharArray(), SALT.encodeToByteArray(), count, 256)
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val keyBytes = factory.generateSecret(keySpec).encoded
        val key =  SecretKeySpec(keyBytes, "AES")
        Log.d("kdfKey",key.toString())
        logKey("kdfKey",key)
    }

    fun logKey(tag: String, key: SecretKeySpec) {
        val keyString = Base64.encodeToString(key.encoded, Base64.NO_WRAP)
        Log.d(tag, keyString)
    }

    companion object {
        //  키 유도 같은 SALT는 같은 키 생성
        private const val SALT = "SALT"
    }
}
