package com.example.usuynmidtest

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usuynmidtest.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val data: ArrayList<MyData> = ArrayList()
    lateinit var adapter: MyAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var tel: String

    val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                callAction(tel)
            }
        }


    val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult() // data 넘기면 자동으로 호출되는 콜백함수를 아래에서 정의
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val inform = it.data?.getSerializableExtra("inform") as MyData
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initRecyclerView()
    }

    private fun initData() {
        binding.register.setOnClickListener {
            var name = binding.name.text.toString()
            var corp = binding.corp.text.toString()
            var tel = binding.tel.text.toString()
            data.add(MyData(name, corp, tel))
            adapter.notifyDataSetChanged()
        }
    }


    private fun initRecyclerView() {
        //recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        adapter = MyAdapter(data)
        adapter.itemClickListener = object : MyAdapter.OnItemClickListener {

            override fun OnNameClick(data: MyData) {
                val intent = Intent(applicationContext, ModifyActivity::class.java)
                intent.putExtra("inform", MyData(data.name, data.corp, data.name, data.count))
                setResult(Activity.RESULT_OK, intent)
                activityResultLauncher.launch(intent)
            }

            override fun OnImageClick(data: MyData) {
                tel = data.tel
                data.count++
                adapter.notifyDataSetChanged()
                callAction(data.tel)
            }

        }

        binding.recyclerView.adapter = adapter


    }

    private fun callAlertDlg() { // 권한 요청 거부시 dialog
        val builder = AlertDialog.Builder(this)

        // OK하면 다시 권한 요청, Cancel하면 dlg 종료
        builder.setMessage("반드시 CALL_PHONE 권한이 허용되어야 합니다.")
            .setTitle("권한 체크")
            .setPositiveButton("OK") { _, _ ->
                requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
            }.setNegativeButton("Cancel") { dlg, _ ->
                dlg.dismiss()
            }

        val dlg = builder.create()
        dlg.show()
    }

    private fun callAction(tel: String) {
        val number = Uri.parse("tel:" + tel)
        val callIntent = Intent(Intent.ACTION_CALL, number)

        when {

            (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) -> {
                startActivity(callIntent) // 권한 체크가 필요 -> 화면 전환
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this, android.Manifest.permission.CALL_PHONE
            ) -> { // 거부했을 때 true 반환
                callAlertDlg()
            }

            else -> {
                requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
            }

        }

    }


}