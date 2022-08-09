package com.machinecode.testandroidproject.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.machinecode.testandroidproject.data.Person
import java.io.IOException


open class UserViewModel : ViewModel() {

    private val userLiveData: MutableLiveData<MutableList<Person>> =
        MutableLiveData<MutableList<Person>>()

    open fun getUser(): LiveData<MutableList<Person>> {
        return userLiveData
    }

    fun getJsonDataFromAsset(context: Context, fileName: String) {
        var jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            jsonString = ""
        }
//        return jsonString
//        userLiveData.value = Gson().fromJson(jsonString, MutableList<Person>)
    }
}