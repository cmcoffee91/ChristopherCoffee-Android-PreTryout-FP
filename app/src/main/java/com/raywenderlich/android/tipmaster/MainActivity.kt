/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.rwandroidtutorial

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {


  var isBillEmpty = true
  var isGuestAmountEmpty = true
  var isPercentEmpty = true

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Your code

    tipAmount.text = getString(R.string.tip, 0.0)

    calculateButton.isEnabled = false


    calculateButton.setOnClickListener {

      var billTotal = billAmountInput.text.toString().toDouble()
      var numberOfGuests = numberOfPeople.text.toString().toDouble()
      var tipPercentage = percentAmountInput.text.toString().toDouble()
      var billSplit = billTotal / numberOfGuests

      var totalTipAmount = (billSplit * tipPercentage) / 100.0


      tipAmount.text = getString(R.string.tip, totalTipAmount)

    }


    initTextListeners()


  }


  fun  initTextListeners(){


    billAmountInput.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(p0: Editable?) {

        isBillEmpty = p0 != null && p0.isEmpty()

        calculateButton.isEnabled = !isBillEmpty && !isGuestAmountEmpty && !isPercentEmpty

      }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }
    })



    numberOfPeople.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(p0: Editable?) {
        isGuestAmountEmpty = p0 != null && p0.isEmpty()

        calculateButton.isEnabled = !isBillEmpty && !isGuestAmountEmpty && !isPercentEmpty
      }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }
    })



    percentAmountInput.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(p0: Editable?) {
        isPercentEmpty = p0 != null && p0.isEmpty()

        calculateButton.isEnabled = !isBillEmpty && !isGuestAmountEmpty && !isPercentEmpty
      }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }
    })


  }


}
