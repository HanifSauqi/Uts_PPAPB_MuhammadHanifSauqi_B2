package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySecondBinding
import java.text.SimpleDateFormat
import java.util.*

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val capaian = arrayOf(
        "Cutting",
        "Bulking",
        "Maintaining"
    )

    private val satuan = arrayOf(
        "Kg",
        "Pound",
        "Lbs"
    )

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BERAT_SAAT_INI = "extra_berat_saat_ini"
        const val EXTRA_BERAT_TUJUAN = "extra_berat_tujuan"
        const val EXTRA_KALORI_HARIAN = "extra_kalori_harian"
        const val EXTRA_TUJUAN = "extra_tujuan"
        const val EXTRA_SELECTED_DATE = "extra_selected_date"
        const val EXTRA_SATUAN_BERAT_1 = "extra_satuan_berat_1"
        const val EXTRA_SATUAN_BERAT_2 = "extra_satuan_berat_2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi spinner tujuan
        val adapterTujuan = ArrayAdapter(
            this@SecondActivity,
            android.R.layout.simple_spinner_item, capaian
        )
        adapterTujuan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTujuan.adapter = adapterTujuan

        // Inisialisasi spinner satuan berat
        val adapterSatuan = ArrayAdapter(
            this@SecondActivity,
            android.R.layout.simple_spinner_item, satuan
        )
        adapterSatuan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSatuanBerat1.adapter = adapterSatuan
        binding.spinnerSatuanBerat2.adapter = adapterSatuan

        binding.datePicker.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val dateFormat = SimpleDateFormat("dd / MM / yyyy", Locale.getDefault())
            val selectedDate = dateFormat.format(calendar.time)

            // Handler tombol "Get Started"
            binding.btnToThird.setOnClickListener {
                if (isAllInputValid()) {
                    val nama = binding.inputNama.text.toString()
                    val beratSaatIni = binding.edtBeratSaatini.text.toString()
                    val beratTujuan = binding.edtBeratTujuan.text.toString()
                    val kaloriHarian = binding.kaloriHarian.text.toString()

                    // Ambil data dari spinner dan date picker
                    val selectedTujuan = binding.spinnerTujuan.selectedItem.toString()
                    val selectedSatuanBerat1 = binding.spinnerSatuanBerat1.selectedItem.toString()
                    val selectedSatuanBerat2 = binding.spinnerSatuanBerat2.selectedItem.toString()

                    // Kirim data ke ThirdActivity
                    val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                        .apply {
                            putExtra(EXTRA_NAME, nama)
                            putExtra(EXTRA_BERAT_SAAT_INI, beratSaatIni)
                            putExtra(EXTRA_BERAT_TUJUAN, beratTujuan)
                            putExtra(EXTRA_KALORI_HARIAN, kaloriHarian)
                            putExtra(EXTRA_TUJUAN, selectedTujuan)
                            putExtra(EXTRA_SATUAN_BERAT_1, selectedSatuanBerat1)
                            putExtra(EXTRA_SATUAN_BERAT_2, selectedSatuanBerat2)
                            putExtra(EXTRA_SELECTED_DATE, selectedDate)
                        }
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this@SecondActivity, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isAllInputValid(): Boolean {
        val nama = binding.inputNama.text.toString()
        val beratSaatIni = binding.edtBeratSaatini.text.toString()
        val beratTujuan = binding.edtBeratTujuan.text.toString()
        val kaloriHarian = binding.kaloriHarian.text.toString()

        // Cek apakah semua input sudah diisi atau tidak
        return nama.isNotEmpty() && beratSaatIni.isNotEmpty() && beratTujuan.isNotEmpty() && kaloriHarian.isNotEmpty()
    }

}
