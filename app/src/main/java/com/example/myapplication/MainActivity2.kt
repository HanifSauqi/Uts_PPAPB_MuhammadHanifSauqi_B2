package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val TAG = "MainActivityLifecycle"

    private lateinit var binding : ActivityMain2Binding
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginTextView = findViewById<TextView>(R.id.textView4)
        loginTextView.setOnClickListener {
            // Tambahkan aksi yang ingin Anda lakukan ketika teks "Log in" diklik di sini
            // Contoh: Buka aktivitas login atau tampilkan pesan.
            val intent = Intent(this@MainActivity2, ThirdActivity::class.java)
            startActivity(intent)
        }

        with(binding) {
            btnToSecond.setOnClickListener {
                val intentToSecondActivity =
                    Intent (this@MainActivity2, SecondActivity::class.java)

                val name = username.text.toString()
                val email = email.text.toString()
                val phone = phone.text.toString()
                val password = password.text.toString()

                intentToSecondActivity.putExtra(EXTRA_NAME,name)
                intentToSecondActivity.putExtra(EXTRA_EMAIL,email)
                intentToSecondActivity.putExtra(EXTRA_PHONE,phone)
                intentToSecondActivity.putExtra(EXTRA_PASSWORD,password)

                startActivity(intentToSecondActivity)
            }
        }

        Log.d(TAG, "oncCreate dipanggil")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy dipanggil")
    }
}