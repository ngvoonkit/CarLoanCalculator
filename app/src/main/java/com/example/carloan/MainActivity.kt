package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            val car_price = editTextCarPrice.text.toString().toInt()
            val down_payment = editTextDownPayment.text.toString().toInt()
            val loan_period = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toFloat()

            val loan = car_price - down_payment

            textViewCarLoan.text = getString(R.string.loan) + ": ${loan}"

            val interest = loan * interest_rate * loan_period

            textViewInterest.text = getString(R.string.interest) + ": ${interest}"

            val monthlyRepayment = (loan + interest)/loan_period/12

            textViewMonthlyRepayment.text = getString(R.string.monthly_repayment) + ": ${monthlyRepayment}"
        }

        buttonReset.setOnClickListener(){
            editTextCarPrice.setText("")
            editTextDownPayment.setText("")
            editTextInterestRate.setText("")
            editTextLoanPeriod.setText("")
            textViewMonthlyRepayment.setText("")
            textViewCarLoan.setText("")
            textViewInterest.setText("")
        }
    }
}
