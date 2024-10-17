package com.example.umc_w4m2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var isRunning = false  // 스톱워치 동작 여부
    private var time = 0L          // 경과 시간 (밀리초)
    private var job: Job? = null   // 코루틴 작업

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textViewTime)
        val buttonStart: Button = findViewById(R.id.buttonStart)
        val buttonClear: Button = findViewById(R.id.buttonClear)

        // Start 버튼 클릭 시
        buttonStart.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                buttonStart.text = "Pause"
                buttonClear.isEnabled = true  // Start 상태에서는 Clear 활성화
                startStopwatch(textView)
            } else {
                isRunning = false
                buttonStart.text = "Start"
                pauseStopwatch()
            }
        }

        // Clear 버튼 클릭 시
        buttonClear.setOnClickListener {
            if (isRunning) {
                // 스톱워치가 실행 중일 때 Clear를 누르면 시간만 초기화 (정지하지 않음)
                clearStopwatchAndContinue(textView)
            } else {
                // 스톱워치가 정지된 상태에서는 Clear 후 초기화
                clearStopwatch(textView)
            }
        }
    }

    // 스톱워치 시작 함수
    private fun startStopwatch(textView: TextView) {
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isRunning) {
                delay(10L)  // 10ms마다 업데이트 (1/100초 단위)
                time += 10L
                val milliseconds = (time % 1000) / 10
                val seconds = (time / 1000) % 60
                val minutes = (time / 1000) / 60
                textView.text = String.format("%02d:%02d,%02d", minutes, seconds, milliseconds)
            }
        }
    }

    // 스톱워치 일시 정지 함수
    private fun pauseStopwatch() {
        job?.cancel()  // 코루틴 정지
    }

    // 스톱워치 초기화 함수 (정지 후 초기화)
    private fun clearStopwatch(textView: TextView) {
        pauseStopwatch()  // 먼저 멈추고
        time = 0L         // 시간을 0으로 초기화
        textView.text = "00:00,00"
    }

    // 스톱워치 초기화 함수 (정지하지 않고 시간만 0으로 초기화)
    private fun clearStopwatchAndContinue(textView: TextView) {
        time = 0L         // 시간을 0으로 초기화
        textView.text = "00:00,00"  // 바로 0초로 갱신
        // 코루틴이 계속 동작하면서 시간이 0에서부터 다시 시작
    }
}
