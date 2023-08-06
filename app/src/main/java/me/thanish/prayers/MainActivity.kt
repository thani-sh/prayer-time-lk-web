package me.thanish.prayers

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    private lateinit var gestures: GestureDetectorCompat

    private var data: JSONObject? = null
    private var time: Date = Date()

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

    private fun updateData() {
        val text = assets.open("values.json").bufferedReader().use {
            it.readText()
        }
        data = JSONObject(text)
    }

    private fun updateTime() {
        val date = SimpleDateFormat("M-d").format(time)
        findViewById<TextView>(R.id.txt_date).text = date
        val times = getPrayerTimes(date) ?: return
        findViewById<TextView>(R.id.txt_time_sahar).text = times[0]
        findViewById<TextView>(R.id.txt_time_fajr).text = times[1]
        findViewById<TextView>(R.id.txt_time_sunrise).text = times[2]
        findViewById<TextView>(R.id.txt_time_zhuhar).text = times[3]
        findViewById<TextView>(R.id.txt_time_asar).text = times[4]
        findViewById<TextView>(R.id.txt_time_maghrib).text = times[5]
        findViewById<TextView>(R.id.txt_time_isha).text = times[6]
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

    override fun onDown(e: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(e: MotionEvent) {
        // TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        time = Date(time.time + 1000 * 60 * 60 * 24)
        updateTime()
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent) {
        time = Date()
        updateTime()
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        return true
    }
}