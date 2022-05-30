package com.example.tinkoff_hr.data

import android.content.Context
import android.content.SharedPreferences

class UserTokenStorage(context: Context) {
    private var settings: SharedPreferences =
        context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)

    private var editor: SharedPreferences.Editor = settings.edit()

    fun saveUserToken(token: String) {
        editor.putString(TOKEN_KEY, token)
        editor.commit()
    }

    fun getUserToken(): String {
        return settings.getString(TOKEN_KEY, "")!!
    }

    companion object {
        private const val STORAGE_NAME = "UserTokenStorage"
        private const val TOKEN_KEY = "TOKEN"
    }
}