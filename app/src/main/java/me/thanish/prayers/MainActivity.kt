package me.thanish.prayers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var data: JSONObject? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateData()
        updateTime()
    }

    override fun onResume() {
        super.onResume()
        updateTime()
    }

    private fun updateData() {
        val text = assets.open("values.json").bufferedReader().use {
            it.readText()
        }
        data = JSONObject(text)
    }

    private fun updateTime() {
        val times = getTime() ?: return
        txt_time_sahar.text = times[0]
        txt_time_fajr.text = times[1]
        txt_time_sunrise.text = times[2]
        txt_time_zhuhar.text = times[3]
        txt_time_asar.text = times[4]
        txt_time_maghrib.text = times[5]
        txt_time_isha.text = times[6]
    }

    private fun getTime(): Array<String>? {
        if ( data == null ) {
            return null
        }
        val date = SimpleDateFormat("yyyy-M-dd").format(Date())
        if ( !data!!.has(date)) {
            return null
        }
        val time = data!!.getJSONArray(date)
        if (time.length() != 7) {
            return null
        }
        return Array(time.length()) {
            time.getString(it)
        }
    }
}
