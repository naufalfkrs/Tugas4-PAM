package com.example.calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CalViewModel : ViewModel() {
    private val _input = MutableStateFlow("")
    val input: StateFlow<String> = _input
    var n: Int = 1
    var n1: String = ""
    var n2: String = ""
    var op: String = ""

    fun onClick(btn: String) {
        _input.value += btn
        when (btn) {
            "+", "-", "*", "/" -> {
                n = 2
                op = btn
            }

            "c" -> {
                n = 1
                _input.value = ""
                n1 = ""
                n2 = ""
            }

            "=" -> {
                var res: Double = 0.0
                when (op) {
                    "+" -> res = n1.toDouble() + n2.toDouble()
                    "-" -> res = n1.toDouble() - n2.toDouble()
                    "*" -> res = n1.toDouble() * n2.toDouble()
                    "/" -> res = n1.toDouble() / n2.toDouble()
                }
                Log.d("KALKULATOR", n1 + op + n2)
                _input.value = _input.value + res
            }

            else -> {
                if (n == 1) {
                    n1 += btn
                } else {
                    n2 += btn
                }
            }
        }
    }
}