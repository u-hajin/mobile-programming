package com.example.usuynmidtest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.usuynmidtest.databinding.ActivityMainBinding
import com.example.usuynmidtest.databinding.ActivityModifyBinding

class ModifyActivity : AppCompatActivity() {
    lateinit var binding: ActivityModifyBinding

    val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult() // data 넘기면 자동으로 호출되는 콜백함수를 아래에서 정의
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val inform = it.data?.getSerializableExtra("inform") as MyData
            binding.textView7.setText(inform.name)
            binding.textView8.setText(inform.corp)
            binding.textView9.setText(inform.tel)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout() {
        activityResultLauncher

        binding.button2.setOnClickListener {
            finish()
        }

        binding.button3.setOnClickListener {
            finish()
        }
    }
}