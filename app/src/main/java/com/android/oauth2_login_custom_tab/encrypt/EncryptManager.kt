package com.android.oauth2_login_custom_tab.encrypt

import android.os.Build
import java.util.Locale

class EncryptManager(
    pw : String,
) {
    val instanceId = pw
    val uuid = pw
    val language = Locale.getDefault().language
    val deviceName = Build.MODEL

    init {
        KeyBuilder(pw= pw)
    }

    fun combine()= listOf(
        instanceId,
        uuid,
        language,
        deviceName,
    ).joinToString("|")
}
