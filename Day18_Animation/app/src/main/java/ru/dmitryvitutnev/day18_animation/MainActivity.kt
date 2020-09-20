package ru.dmitryvitutnev.day18_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationSun = AnimationUtils.loadAnimation(this, R.anim.sun_rise)
        sun.startAnimation(animationSun)

        val animationClock = AnimationUtils.loadAnimation(this, R.anim.clock_turn)
        clock.startAnimation(animationClock)

        val animationHour = AnimationUtils.loadAnimation(this, R.anim.hour_turn)
        hour_hand.startAnimation(animationHour)
    }
}