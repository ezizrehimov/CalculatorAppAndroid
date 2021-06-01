package com.eziz.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun btnAddNumber(view: View) {
        val seeValue: TextView = findViewById(R.id.seeValue)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btnMenfiMustbet: Button = findViewById(R.id.btnMenfiMusbet)
        if (newOperator) {
            seeValue.setText("")
        }
        newOperator = false
        var btnChoose = view as Button
        var btnClickValue: String = seeValue.text.toString()
        when (btnChoose.id) {
            btn0.id -> {
                btnClickValue += "0"
            }
            btn1.id -> {
                btnClickValue += "1"
            }
            btn2.id -> {
                btnClickValue += "2"
            }
            btn3.id -> {
                btnClickValue += "3"
            }
            btn4.id -> {
                btnClickValue += "4"
            }
            btn5.id -> {
                btnClickValue += "5"
            }
            btn6.id -> {
                btnClickValue += "6"
            }
            btn7.id -> {
                btnClickValue += "7"
            }
            btn8.id -> {
                btnClickValue += "8"
            }
            btn9.id -> {
                btnClickValue += "9"
            }
            btnMenfiMustbet.id -> {
                btnClickValue = "-" + btnClickValue
            }
        }
        seeValue.setText(btnClickValue)
    }

    var operator = "*"
    var oldValue = ""
    var newOperator = true

    fun btnOpClick(view: View) {
        val seeValue: TextView = findViewById(R.id.seeValue)
        val btnBolme: Button = findViewById(R.id.btnBolme)
        val btnVurma: Button = findViewById(R.id.btnVurma)
        val btnCixma: Button = findViewById(R.id.btnCixma)
        val btnToplama: Button = findViewById(R.id.btnToplama)
        var btnChoose = view as Button

        when (btnChoose.id) {
            btnBolme.id -> {
                operator = "/"
            }
            btnVurma.id -> {
                operator = "x"
            }
            btnCixma.id -> {
                operator = "-"
            }
            btnToplama.id -> {
                operator = "+"
            }
        }
        oldValue = seeValue.text.toString()
        newOperator = true
    }


    fun btnClick(view: View) {
        val seeValue: TextView = findViewById(R.id.seeValue)

        var newValue = seeValue.text.toString()
        var totalValue: Double? = null
        when (operator) {
            "/" -> {
                totalValue = oldValue.toDouble() / newValue.toDouble()
            }
            "x" -> {
                totalValue = oldValue.toDouble() * newValue.toDouble()
            }
            "-" -> {
                totalValue = oldValue.toDouble() - newValue.toDouble()
            }
            "+" -> {
                totalValue = oldValue.toDouble() + newValue.toDouble()
            }
        }
        seeValue.setText(totalValue.toString())
        newOperator = true
    }

    fun btnReset(view: View) {
        val seeValue: TextView = findViewById(R.id.seeValue)

        seeValue.setText("0")
        newOperator = true
    }

    fun btnFaiz(view: View) {
        val seeValue: TextView = findViewById(R.id.seeValue)

        var value: Double = seeValue.text.toString().toDouble() / 100
        seeValue.setText(value.toString())
        newOperator = true
    }
}