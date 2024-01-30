package com.achmad.baseandroid.cache

import android.content.Context
import android.content.SharedPreferences

object PreferenceManager {
    const val NAME = "BasePref"
    const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_FIRST_OPEN = Pair("IS_FIRST_OPEN", true)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    /**
     * SharedPreferences extension function, so we won't need to call edit()
     * and apply() ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isFirstOpen: Boolean
        get() = preferences.getBoolean(IS_FIRST_OPEN.first, IS_FIRST_OPEN.second)
        set(value) =
            preferences.edit {
                it.putBoolean(IS_FIRST_OPEN.first, value)
            }
}
