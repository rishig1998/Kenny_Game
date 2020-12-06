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
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var score=0
    var imagearry=ArrayList<ImageView>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        score=0
        object :CountDownTimer(10000,1000)
        {
            override fun onFinish() {
                timeText.text="Time:0"
            }

            override fun onTick(p0: Long) {
                timeText.text="Time"+p0/1000

            }

        }.start()
        imagearry= arrayListOf(imageView0,imageView1,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)




    }
    fun hideimage()
    {
        for(image in imagearry)
        {
            image.visibility=View.INVISIBLE
        }
    }

    fun increasescore(view:View)
    {
        score++
        scoreText.text="Score:"+score
    }

}