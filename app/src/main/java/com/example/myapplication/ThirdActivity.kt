package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.MainActivity2.Companion.EXTRA_NAME
import com.example.myapplication.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding
    companion object{
        const val EXTRA_ADDRESS = "extra_addres"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val name = intent.getStringExtra(EXTRA_NAME)

        val btnToOne = findViewById<Button>(R.id.btn_to_one)
        btnToOne.setOnClickListener {
            val intent = Intent(this@ThirdActivity, MainActivity2::class.java)
            startActivity(intent)
        }

//        with(binding){


//            btnDismiss.setOnClickListener{
//                val intent = Intent ();
//                intent.putExtra(EXTRA_NAME, name)
//
//                val address = editTextAddres.text.toString()
//                intent.putExtra(EXTRA_ADDRESS, address)
//
//                setResult(Activity.RESULT_OK, intent)
//                finish()
//            }

//        }
    }
}