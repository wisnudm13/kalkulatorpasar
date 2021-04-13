package com.example.calculator

import android.content.res.Configuration
import android.os.Bundle
import android.view.OrientationEventListener
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.math.floor
import kotlin.math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var number = ""
    var newNumber = ""
    var operation = ""
    var dot = true
    var percent = true
    var percentInNumber = false
    var percentInNewNumber = false
    var percentExist = false
    val decimalFormateSymbol = DecimalFormatSymbols()

    val resultDecimal = DecimalFormat()
    val bigIntDecimal = DecimalFormat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkOrientation()

        resultDecimal.applyPattern("#,###.##########")
        bigIntDecimal.applyPattern("0.000000000000000E+0")

        editTextTop.setShowSoftInputOnFocus(false);
    }

    fun checkOrientation(): Int {
        var orientation = this.resources.configuration.orientation

        return orientation
    }

    fun checkLength(): Int {
        var text = editTextTop.text.toString()

        return text.length
    }

    fun checkNumeric(): Int {
        var text = editTextTop.text.toString()
        var count = 0;

        for(i in text) {
            if(i.isDigit()) {
                count++;
            }
        }

        return count

    }

    fun checkDot() {
        var text = editTextTop.text.toString()
        var count = 0

        for(i in text) {
            if(i == '.') {
                count++
            }

        }

        dot = count == 0
    }

    fun checkPercent() {
        var text = editTextTop.text.toString()
        var count = 0

        for(i in text ) {
            if(i == '%') {
                count++
            }
        }

        percent = count == 0
    }

    fun backspaceButton(view: View) {
        var str = editTextTop.text.toString()

        if(str.length > 1) {
            str = str.substring(0, str.length - 1)

        } else {
            str = "0"
            isNewOp = true
        }

        checkDot()
        checkPercent()

        if(checkNumeric() == 10) {
            editTextTop.setTextSize(35F)

        } else if(checkNumeric() < 10) {
            editTextTop.setTextSize(50F)
        }

        editTextTop.setText(str)
    }

    fun numberEvent(view: View) {
        checkDot()
        checkPercent()

        if(isNewOp) {
            editTextTop.setText("")
            isNewOp = false
            editTextTop.setTextSize(50F)

        }

        var editTextTopText = findViewById<EditText>(R.id.editTextTop).text.toString()

        var buttonSelect = view as Button

        var stringOutput = editTextTopText.replace(",","").replace("%","")
        editTextTopText = stringOutput

        percentExist = editTextTopText.contains('%')

        if(checkOrientation().equals(Configuration.ORIENTATION_PORTRAIT)) {
            if(checkNumeric() == 10) {
                editTextTop.setTextSize(35F)

            } else if(checkNumeric() > 14) {
                editTextTop.setTextSize(30F)
            }

        }

        when(buttonSelect.id) {
            buttonAC.id -> editTextTop.setText("")

            button1.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "1"

                        } else {
                            editTextTopText += "1"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }

                }

            button2.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "2"

                        } else {
                            editTextTopText += "2"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }

                }

            button3.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "3"

                        } else {
                            editTextTopText += "3"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }

                }

            button4.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "4"

                        } else {
                            editTextTopText += "4"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }
                }

            button5.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "5"

                        } else {
                            editTextTopText += "5"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }
                }

            button6.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "6"

                        } else {
                            editTextTopText += "6"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }
                }

            button7.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "7"

                        } else {
                            editTextTopText += "7"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }
                }


            button8.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "8"

                        } else {
                            editTextTopText += "8"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }
                }

            button9.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "0") {
                            editTextTopText = ""
                            editTextTopText += "9"

                        } else {
                            editTextTopText += "9"
                        }

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }
                }

            button0.id ->
                if(!percentExist) {
                    if(checkNumeric() < 15) {
                        if(editTextTopText == "" || editTextTopText == "0") editTextTopText = "0" else editTextTopText  += "0"

                    } else {
                        Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                    }
                }

            buttonDot.id -> if(percent) {
                if(dot) {
                    if(editTextTopText == "" || isNewOp) {
                        editTextTopText += "0."

                    } else {
                        if(checkNumeric() < 15) {
                            editTextTopText += "."

                        } else {
                            Toast.makeText(this@MainActivity, "Digit can't be more than 15 digit", Toast.LENGTH_SHORT).show()
                        }

                    }

                    dot = false

                }
            }

            buttonPlusMinus.id -> {
                if(editTextTopText == "" || editTextTopText == "0") {
                    editTextTopText = "0"

                } else {
                    if(editTextTopText.contains('-')) {
                        var removeNegative = editTextTopText.replace("-","")
                        editTextTopText = removeNegative

                    } else {
                        editTextTopText = "-" + editTextTopText
                    }

                }

            }

            buttonPercent.id -> if(percent){
                if(editTextTopText == "" || editTextTopText == "0") {
                    editTextTopText = "0"

                } else {
                    if(editTextTopText[editTextTopText.length - 1].isDigit()) {
                        if(editTextTopText[editTextTopText.length - 1] != '0') {
                            editTextTopText += "%"
                        }
                    }

                    percent = false

                }

            }

        }

        //editTextTop.setText(editTextTopText)

        if(editTextTopText.contains('%')) {
            var stringOutput = editTextTopText.replace("%","")
            editTextTopText = stringOutput

            if(editTextTopText.contains('.')) {
                var firstString = editTextTopText.substring(0, editTextTopText.indexOf('.'))
                var secondString = editTextTopText.substring(editTextTopText.indexOf('.'), editTextTopText.length)
                editTextTop.setText(resultDecimal.format(firstString.toLong()).toString() + secondString + "%")

            } else {
                editTextTop.setText(resultDecimal.format(editTextTopText.toLong()).toString() + "%")

            }

        } else {
            var stringOutput = editTextTopText.replace("%","")
            editTextTopText = stringOutput

            if(editTextTopText.contains('.')) {
                var firstString = editTextTopText.substring(0, editTextTopText.indexOf('.'))
                var secondString = editTextTopText.substring(editTextTopText.indexOf('.'), editTextTopText.length)
                editTextTop.setText(resultDecimal.format(firstString.toLong()).toString() + secondString)

            } else {
                editTextTop.setText(resultDecimal.format(editTextTopText.toLong()).toString())
            }
        }

    }

    fun operatorEvent(view: View) {
        number = editTextTop.text.toString()

        percentInNumber = number.contains('%')

        var numberOutput = number.replace(",","").replace("%","")
        var buttonSelect = view as Button

        when(buttonSelect.id) {
            buttonPlus.id -> operation = "+"
            buttonMinus.id -> operation = "-"
            buttonMultiply.id -> operation = "\u00D7"
            buttonDivide.id -> operation = "\u00F7"
        }

        if(percentInNumber) {
            var percentString = numberOutput.toDouble() / 100
            number = percentString.toString()
            //Toast.makeText(this@MainActivity, numberOutput, Toast.LENGTH_SHORT).show()
        }

        if(operation == "+" || operation == "-" || operation == "\u00D7" || operation == "\u00F7") {
            textViewTop.setText(number + " " + operation)
        }

        isNewOp = true
        dot = true
        percent = true

    }

    fun resultEvent(view: View) {
        newNumber = editTextTop.text.toString()
        percentInNewNumber = newNumber.contains('%')
        percentInNumber = number.contains('%')
        checkNumeric()
        var result = 0.0
        textViewTop.setText(number +  " " + operation + " " + newNumber  + " =")
        var numberOutput = number.replace(",","").replace("%","")
        var newNumberOutput = newNumber.replace(",","").replace("%","")

        if(percentInNumber) {
            var temp = numberOutput.toDouble() / 100
            newNumberOutput = temp.toString()

        }

        if(percentInNewNumber) {
            if(percentInNumber) {
                if(operation == "+" || operation == "-") {
                    var temp = newNumberOutput.toDouble() / 100
                    newNumberOutput = temp.toString()
                }


            } else {
                if(operation == "+" || operation == "-") {
                    var temp = (numberOutput.toDouble() * newNumberOutput.toDouble()) / 100
                    newNumberOutput = temp.toString()

                }

            }
        }

        if(!operation.equals("") ) {
            //textViewTop.setText(numberOutput +  " " + operation + " " + newNumberOutput  + " =")

            when(operation) {
                "+" -> result = numberOutput.toDouble() + newNumberOutput.toDouble()
                "\u00D7" -> result = numberOutput.toDouble() * newNumberOutput.toDouble()
                "\u00F7" -> result = numberOutput.toDouble() / newNumberOutput.toDouble()
                "-" -> result = numberOutput.toDouble() - newNumberOutput.toDouble()
            }

            if(percentInNewNumber) {
                if(operation == "\u00D7") {
                    result /= 100

                } else if(operation == "\u00F7"){
                    result *= 100
                }
            }

            if(checkOrientation().equals(Configuration.ORIENTATION_PORTRAIT)) {
                if(result.toString().length > 15) {
                    editTextTop.setTextSize(30F)
                }
            }

            if(result == floor(result) && !result.isInfinite()) {
                if(result > Double.MAX_VALUE) {
                    Toast.makeText(this@MainActivity, "Maximum Output Value Exceeded", Toast.LENGTH_SHORT).show()

                } else {
                    if(result > Long.MAX_VALUE || result < Long.MIN_VALUE) {
                        editTextTop.setText(bigIntDecimal.format(result).toString())

                    } else {
                        editTextTop.setText(resultDecimal.format(result).toString())
                    }
                }



            } else {
                if(result > Double.MAX_VALUE) {
                    Toast.makeText(this@MainActivity, "Maximum Output Value Exceeded", Toast.LENGTH_SHORT).show()

                } else {
                    var firstString = result.toString().substring(0, result.toString().indexOf("."))
                    var secondString = result.toString().substring(result.toString().indexOf("."), result.toString().length)

                    //Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_SHORT).show()
                    editTextTop.setText(resultDecimal.format(firstString.toInt()) + secondString)
                }


            }

        } else {
            editTextTop.setText(newNumber)
        }

        dot = true
        isNewOp = true
        percent = true

    }

    fun reset(view: View) {
        editTextTop.setText("0")
        textViewTop.setText("")
        isNewOp = true
        dot = true
        percent = true
        percentExist = false
        editTextTop.setTextSize(50F)
        operation = ""
        newNumber = ""
        number = ""
    }

}