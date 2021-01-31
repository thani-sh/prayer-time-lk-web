package me.thanish.prayers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.view.GestureDetector
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    lateinit var gestures: GestureDetectorCompat

    var data: JSONObject? = null
    var time: Date = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestures = GestureDetectorCompat(this, this)
        updateData()
        updateTime()
    }

    override fun onResume() {
        super.onResume()
        updateTime()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestures.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onShowPress(e: MotionEvent?) {
        // ...
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        time = Date(time.time + 1000 * 60 * 60 * 24)
        updateTime()
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        time = Date()
        updateTime()
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        return false
    }

    private fun updateData() {
        val text = assets.open("values.json").bufferedReader().use {
            it.readText()
        }
        data = JSONObject(text)
    }

    private fun updateTime() {
        val date = SimpleDateFormat("M-d").format(time)
        txt_date.text = date
        val times = getPrayerTimes(date) ?: return
        txt_time_sahar.text = times[0]
        txt_time_fajr.text = times[1]
        txt_time_sunrise.text = times[2]
        txt_time_zhuhar.text = times[3]
        txt_time_asar.text = times[4]
        txt_time_maghrib.text = times[5]
        txt_time_isha.text = times[6]
    }

    private fun getPrayerTimes(date: String): Array<String>? {
        if ( data == null ) {
            return null
        }
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
