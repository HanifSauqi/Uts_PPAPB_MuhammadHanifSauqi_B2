package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.MainActivity2.Companion.EXTRA_EMAIL
import com.example.myapplication.MainActivity2.Companion.EXTRA_NAME
import com.example.myapplication.MainActivity2.Companion.EXTRA_PHONE
import com.example.myapplication.ThirdActivity.Companion.EXTRA_ADDRESS

import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val name = data?.getStringExtra(EXTRA_NAME)
                val address = data?.getStringExtra(EXTRA_ADDRESS)

//                binding.txtName.text = "Hello $name di $address"
            }
//            TODO : add collback function after next is dismissed
//            update txtname dengan alamat dari activity yg ke tiga
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        with(binding){
//            txtName.text = "Hello $name !"
            txtEmail.text = "Your $email has been activated  "
            txtPhone.text = "Phone $phone has been registered  "
            txtUsername.text = "Welcome $name "

            btnToThird.setOnClickListener{
                val intent = Intent (this@SecondActivity, ThirdActivity::class.java)
                    .apply { putExtra(EXTRA_NAME, name) }
                launcher.launch(intent)
            }
        }
    }

}