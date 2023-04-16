package com.example.sharedprefdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sharedprefdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var moBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(moBinding.root)

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        val txt = sharedPreference.getString("text","")
        Log.e("save data","pref ${ txt}")
        val switch = sharedPreference.getBoolean("switch",false)
        Log.e("save data", "pref ${ switch}")


        moBinding.tvPrint.text = txt
        moBinding.onOff.isChecked= switch

        moBinding.btnMove.setOnClickListener {
            moBinding.tvPrint.text = moBinding.etText.text
            Log.e("print",moBinding.tvPrint.text.toString())
        }

        moBinding.btnSave.setOnClickListener {
            val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("text",moBinding.tvPrint.text.toString())
            Log.e("print",moBinding.tvPrint.text.toString())
            editor.putBoolean("switch",moBinding.onOff.isChecked)
            editor.apply()
            Toast.makeText(this,"Save data Successfully...",Toast.LENGTH_SHORT).show()
        }
    }
}