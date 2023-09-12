package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var inputTextView: TextView
//    private lateinit var hasilSementaraTextView: TextView
//
//    private var inputBuffer = StringBuilder()
//    private var hasilSementara = 0.0
//    private var operator = ""
//    private var isOperatorClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        inputTextView = binding.input
//        hasilSementaraTextView = binding.hasilSementara
//
//        val buttons = arrayOf(
//            binding.button0, binding.button1, binding.button2, binding.button3,
//            binding.button4, binding.button5, binding.button6, binding.button7,
//            binding.button8, binding.button9
//        )
//
//        for (button in buttons) {
//            button.setOnClickListener {
//                onNumberButtonClick(button.text.toString())
//            }
//        }
//
//        val operators = arrayOf(
//            binding.buttonPlus, binding.buttonMinus, binding.buttonKali, binding.buttonBagi
//        )
//
//        for (operatorButton in operators) {
//            operatorButton.setOnClickListener {
//                onOperatorButtonClick(operatorButton.text.toString())
//            }
//        }
//
//        val clearButton = binding.buttonC
//        clearButton.setOnClickListener {
//            clear()
//        }
//
//        val equalButton = binding.buttonTotal
//        equalButton.setOnClickListener {
//            calculate()
//        }
//
//        val deleteButton = binding.buttonHapus
//        deleteButton.setOnClickListener {
//            delete()
//        }
//
//        val decimalButton = binding.buttonKoma
//        decimalButton.setOnClickListener {
//            onDecimalButtonClick()
//        }
//
//        val doubleZeroButton = binding.button00
//        doubleZeroButton.setOnClickListener {
//            onDoubleZeroButtonClick()
//        }
//    }
//
//    private fun onNumberButtonClick(number: String) {
//        if (hasilSementaraTextView.text.toString() != "Error") {
//            if (isOperatorClicked) {
//                inputBuffer.clear()
//                isOperatorClicked = false
//            }
//            inputBuffer.append(number)
//            updateInputText()
//        }
//    }
//
//    private fun onOperatorButtonClick(operator: String) {
//        if (inputBuffer.isNotEmpty()) {
//            calculate()
//            this.operator = operator
//            isOperatorClicked = true
//            inputBuffer.append(" $operator ")
//            updateInputText()
//        }
//    }
//
//    private fun onDecimalButtonClick() {
//        if (!inputBuffer.contains(".")) {
//            inputBuffer.append(".")
//            updateInputText()
//        }
//    }
//
//    private fun onDoubleZeroButtonClick() {
//        if (inputBuffer.isNotEmpty()) {
//            inputBuffer.append("00")
//            updateInputText()
//        }
//    }
//
//    private fun calculate() {
//        if (inputBuffer.isNotEmpty() && operator.isNotEmpty()) {
//            val inputValue = inputBuffer.toString().toDouble()
//            when (operator) {
//                "+" -> hasilSementara += inputValue
//                "-" -> hasilSementara -= inputValue
//                "x" -> hasilSementara *= inputValue
//                "/" -> {
//                    if (inputValue != 0.0) {
//                        hasilSementara /= inputValue
//                    } else {
//                        // Handle division by zero
//                        clear()
//                        hasilSementaraTextView.text = "Error"
//                        return
//                    }
//                }
//            }
//            clearInput()
//            updateInputText()
//        }
//    }
//
//    private fun clear() {
//        inputBuffer.clear()
//        operator = ""
//        hasilSementara = 0.0
//        isOperatorClicked = false
//        clearInput()
//        hasilSementaraTextView.text = ""
//    }
//
//    private fun delete() {
//        if (inputBuffer.isNotEmpty()) {
//            inputBuffer.deleteCharAt(inputBuffer.length - 1)
//            updateInputText()
//        }
//    }
//
//    private fun clearInput() {
//        inputBuffer.clear()
//    }
//
//    private fun updateInputText() {
//        inputTextView.text = inputBuffer.toString()
//        hasilSementaraTextView.text = String.format("%.2f", hasilSementara)
//    }
    }
}
