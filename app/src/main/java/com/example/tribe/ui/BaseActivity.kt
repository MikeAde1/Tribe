package com.example.tribe.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity


 open class BaseActivity : AppCompatActivity() {

     var loggedOut = false

     override fun onResume() {
         super.onResume()
         if (isValidLogin)
             sharedPreference.edit().putLong(LAST_INTERACTION_TIME, System.currentTimeMillis()).apply()
         else {
             loggedOut = true
             logout()
         }
     }

     private val sharedPreference: SharedPreferences
         get() = getSharedPreferences(PREF_FILE, MODE_PRIVATE)
     private val isValidLogin: Boolean
         get() {
             val lastEditTime = sharedPreference.getLong(LAST_INTERACTION_TIME, 0)
             //checks time difference between when the app was last visible and the current time
             return lastEditTime == 0L || System.currentTimeMillis() - lastEditTime < TIMEOUT_IN_MILLI
         }

     private fun logout() {
         val intent = Intent(this, LogoutPage::class.java)
         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
         startActivity(intent)
         finish()
         sharedPreference.edit().remove(LAST_INTERACTION_TIME).apply() // make shared preference null.
     }

     companion object {
         const val TIMEOUT_IN_MILLI = (60*1000).toLong() //logout after 1 minute of inactivity
         const val PREF_FILE = "App_Pref" //not needed is a shared preferences class is already created
         const val LAST_INTERACTION_TIME = "KEY_SP_LAST_INTERACTION_TIME"
     }

     override fun onPause() {
         super.onPause()
         if (!isValidLogin && !loggedOut) {
             loggedOut = true
             logout()
         }
     }
}