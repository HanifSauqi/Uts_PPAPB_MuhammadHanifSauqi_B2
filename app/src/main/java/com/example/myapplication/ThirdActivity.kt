package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.SecondActivity.Companion.EXTRA_BERAT_SAAT_INI
import com.example.myapplication.SecondActivity.Companion.EXTRA_BERAT_TUJUAN
import com.example.myapplication.SecondActivity.Companion.EXTRA_KALORI_HARIAN
import com.example.myapplication.SecondActivity.Companion.EXTRA_NAME
import com.example.myapplication.SecondActivity.Companion.EXTRA_SATUAN_BERAT_1
import com.example.myapplication.SecondActivity.Companion.EXTRA_SATUAN_BERAT_2
import com.example.myapplication.SecondActivity.Companion.EXTRA_SELECTED_DATE
import com.example.myapplication.SecondActivity.Companion.EXTRA_TUJUAN
import com.example.myapplication.databinding.ActivityThirdBinding
import java.text.SimpleDateFormat
import java.util.*

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val calendar = Calendar.getInstance()

    private val items: MutableList<String> = mutableListOf("Pilih Tanggal")

    private lateinit var dateSpinner: Spinner
    private lateinit var spinnerAdapter: ArrayAdapter<String>

    companion object {
        const val EXTRA_KALORI_TARGET = "extra_kalori_target"
        const val EXTRA_KALORI_SEMULA1 = "extra_kalori_semula1"
        const val EXTRA_KALORI_SEMULA2 = "extra_kalori_semula2"
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val totalKaloriMasuk = data?.getIntExtra(InputActivity.EXTRA_KALORI_MASUK, 0) ?: 0
                val totalKaloriKeluar = data?.getIntExtra(InputActivity.EXTRA_KALORI_KELUAR, 0) ?: 0
                val sisaKalori = data?.getIntExtra(InputActivity.EXTRA_SISA_KALORI, 0) ?: 0

                binding.angkaSisakalori.text = sisaKalori.toString()
                binding.angkaKaloriin.text = totalKaloriMasuk.toString()
                binding.angkaKaloriout.text = totalKaloriKeluar.toString()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra(EXTRA_NAME)
        val beratSaatIni = intent.getStringExtra(EXTRA_BERAT_SAAT_INI)
        val beratTujuan = intent.getStringExtra(EXTRA_BERAT_TUJUAN)
        val kaloriHarian = intent.getStringExtra(EXTRA_KALORI_HARIAN)
        val tujuan = intent.getStringExtra(EXTRA_TUJUAN)
        val satuanBerat1 = intent.getStringExtra(EXTRA_SATUAN_BERAT_1)
        val satuanBerat2 = intent.getStringExtra(EXTRA_SATUAN_BERAT_2)
        val selectedDate = intent.getStringExtra(EXTRA_SELECTED_DATE)

        // Gunakan data yang diterima untuk mengupdate tampilan
        binding.valueNama.text = nama
        binding.valueBeratbadansaatini.text = beratSaatIni
        binding.valueBeratbadantarget.text = beratTujuan
        binding.valueKaloriharian.text = kaloriHarian
        binding.valueTujuan.text = tujuan
        binding.valueSatuan1.text = satuanBerat1
        binding.valueSatuan2.text = satuanBerat2
        binding.valueTargetcapaian.text = selectedDate
        binding.angkaTargetkalori.text = kaloriHarian
        binding.angkaSisakalori.text = kaloriHarian

        dateSpinner = binding.dateSpinner
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dateSpinner.adapter = spinnerAdapter

        dateSpinner.setOnTouchListener { _, _ ->
            showDatePickerDialog()
            true
        }

        binding.btnInput.setOnClickListener {
            val kaloriTarget = binding.angkaSisakalori.text.toString().toInt()
            val kaloriMasukSemula = binding.angkaKaloriin.text.toString().toInt()
            val kaloriKeluarSemula = binding.angkaKaloriout.text.toString().toInt()

            val intent = Intent(this@ThirdActivity, InputActivity::class.java)
                .apply {
                    putExtra(EXTRA_KALORI_TARGET, kaloriTarget)
                    putExtra(EXTRA_KALORI_SEMULA1, kaloriMasukSemula)
                    putExtra(EXTRA_KALORI_SEMULA2, kaloriKeluarSemula)
                }
            launcher.launch(intent)
        }
    }
    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = formatDate1(year, month, dayOfMonth)
                items.add(selectedDate)
                spinnerAdapter.notifyDataSetChanged()
                dateSpinner.setSelection(items.size - 1)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun formatDate1(year: Int, month: Int, dayOfMonth: Int): String {
        val selectedCalendar = Calendar.getInstance()
        selectedCalendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return if (selectedCalendar.time == Calendar.getInstance().time) {
            "Hari Ini"
        } else {
            dateFormat.format(selectedCalendar.time)
        }
    }
}