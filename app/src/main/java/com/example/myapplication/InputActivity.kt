package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ThirdActivity.Companion.EXTRA_KALORI_SEMULA1
import com.example.myapplication.ThirdActivity.Companion.EXTRA_KALORI_SEMULA2
import com.example.myapplication.ThirdActivity.Companion.EXTRA_KALORI_TARGET
import com.example.myapplication.databinding.ActivityInputBinding


class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding

    companion object {
        const val EXTRA_KALORI_MASUK = "extra_kalori_masuk"
        const val EXTRA_KALORI_KELUAR = "extra_kalori_keluar"
        const val EXTRA_SISA_KALORI = "extra_sisa_kalori"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val targetKalori = intent.getIntExtra(EXTRA_KALORI_TARGET, 0)
        val kaloriMasukSemula = intent.getIntExtra(EXTRA_KALORI_SEMULA1, 0)
        val kaloriKeluarSemula = intent.getIntExtra(EXTRA_KALORI_SEMULA2, 0)

        binding.btnSimpan.setOnClickListener {
            // Mengambil data dari inputan
            val kaloriMasuk = binding.editKaloriMasuk.text.toString().toIntOrNull() ?: 0
            val kaloriKeluar = binding.editKaloriKeluar.text.toString().toIntOrNull() ?: 0

            // Melakukan perhitungan untuk mendapatkan sisa kalori
            val totalKaloriMasuk = kaloriMasukSemula + kaloriMasuk
            val totalKaloriKeluar = kaloriKeluarSemula + kaloriKeluar
            val sisaKalori = targetKalori - kaloriMasuk + kaloriKeluar

            // Membuat Intent untuk mengirim data kembali ke ThirdActivity
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_KALORI_MASUK, totalKaloriMasuk)
            resultIntent.putExtra(EXTRA_KALORI_KELUAR, totalKaloriKeluar)
            resultIntent.putExtra(EXTRA_SISA_KALORI, sisaKalori)

            // Mengirim data kembali ke ThirdActivity
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
