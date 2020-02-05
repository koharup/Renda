package app.sano.picchi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tapCount :Int = 0
    //残り秒数を10にする
    var second = 10

    val timer :CountDownTimer = object :CountDownTimer(10000,1000){

        override fun onFinish() {

            startButton.isVisible = true
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle_gray)
            second = 10
            tapCount = 0
        }

        override fun onTick(millisUntilFinished: Long) {
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle)
            second = second - 1
            secondText.text = second.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            //タップされた数をテキストに表示
            countText.text = tapCount.toString()
            startButton.isVisible = false

            timer.start()

        }


        countText.text = "0"

        tapButton.setOnClickListener {
            if (second < 10){
                tapCount  = tapCount + 1
                countText.text = tapCount.toString()
            }
        }
    }
}
