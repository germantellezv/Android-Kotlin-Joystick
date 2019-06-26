package com.example.joysticktest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), JoystickView.JoystickListener {

    var texto:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val joystick = JoystickView(this)
        setContentView(R.layout.activity_main)


        texto = findViewById<TextView>(R.id.tvLog)
    }

    override fun onJoystickMoved(xPercent: Float, yPercent: Float, id: Int) {

        when (id) {

            R.id.joystickLeft ->
            {
                Log.d("Left Joystick", "X percent: $xPercent Y percent: $yPercent")

                if ((yPercent < 0.3 && yPercent > -0.3) && (xPercent > 0.0 && xPercent < 1.0 ))
                {
                    tvLog.text = "DERECHA"
                }
                if ((yPercent < 0.3 && yPercent > -0.3) && (xPercent < 0.0 && xPercent > -1.0 ))
                {
                    tvLog.text = "IZQUIERDA"
                }
                if ((yPercent > -1.0 && yPercent < 0.0) && (xPercent > -0.3 && xPercent < 0.3 ))
                {
                    tvLog.text = "AVANZAR"
                }
                if ((yPercent > 0.0 && yPercent < 1.0) && (xPercent > -0.3 && xPercent < 0.3 ))
                {
                    tvLog.text = "REVERSA"
                }
                if (yPercent == 0F && xPercent == 0F)
                {
                    tvLog.text = ""
                }



            }

        }
    }
}