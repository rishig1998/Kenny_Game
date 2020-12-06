package com.example.kennygame

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.postDelayed
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var score=0
    var imagearry=ArrayList<ImageView>()
    var handler=Handler()
    var runnable= Runnable {  }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        score=0
        object :CountDownTimer(10000,1000)
        {
            override fun onFinish() {
                timeText.text="Time:0"
                handler.removeCallbacks(runnable)
                for(image in imagearry)
                {
                    image.visibility=View.INVISIBLE
                }
            }

            override fun onTick(p0: Long) {
                timeText.text="Time"+p0/1000

            }

        }.start()
        imagearry= arrayListOf(imageView0,imageView1,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)

        hideimage()


    }
    fun hideimage()
    {
        runnable=object :Runnable{
            override fun run() {
                for(image in imagearry)
                {
                    image.visibility=View.INVISIBLE
                }
                val random=Random()
                val index=random.nextInt(8-0)
                imagearry[index].visibility=View.VISIBLE
                handler.postDelayed(this,500)
            }


        }
            handler.post(runnable)
    }

    fun increasescore(view:View)
    {
        score++
        scoreText.text="Score:"+score
    }

}