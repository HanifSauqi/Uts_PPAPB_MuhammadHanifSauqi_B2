package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
//private var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
//
//    with(binding) {
//        textNumber.text = number.toString()
//        btnCount.setOnClickListener{
//            number++
//            textNumber.text = number.toString()
//        }
//        btnToast.setOnClickListener{
////            number--
////            textNumber.text = number.toString()
//            Toast.makeText(this@MainActivity,"count $number",
//                Toast.LENGTH_SHORT).show()
//        }
//    }

}
}