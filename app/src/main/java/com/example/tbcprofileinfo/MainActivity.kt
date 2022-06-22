package com.example.tbcprofileinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.withStyledAttributes
import com.example.tbcprofileinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        listeners()

    }

    private fun listeners() {
        binding.btnSave.setOnClickListener {

            val email = binding.edEmail.text.toString()
            val username = binding.edUsername.text.toString()
            val firstName = binding.edFirstName.text.toString()
            val lastName = binding.edLastName.text.toString()
            val age = binding.edAge.text.toString()

            userInfoValidation(email = email, username = username, firstName = firstName, lastName = lastName, age = age)

        }

        binding.btnClear.setOnLongClickListener {
            Toast.makeText(this, "inputs are cleared", Toast.LENGTH_SHORT).show()
            clearInput()
            return@setOnLongClickListener true
        }
    }


    private fun userInfoValidation(
        email: String,
        firstName: String,
        lastName: String,
        username: String,
        age: String
    ): Boolean {

        try {
            if (email.isEmpty() || !email.contains("@") || !email.contains(".com")) {
                Toast.makeText(this, "input email correctly", Toast.LENGTH_LONG).show()
                return false
            } else if (username.isEmpty() || username.length < 10) {
                Toast.makeText(this, "input username correctly", Toast.LENGTH_LONG).show()
                return false
            } else if (age.toInt() % 1 != 0 || age.isEmpty()) {
                Toast.makeText(this, "input age correctly", Toast.LENGTH_LONG).show()
                return false
            } else if (firstName.isEmpty()) {
                Toast.makeText(this, "input first name correctly", Toast.LENGTH_LONG).show()
                return false
            } else if (lastName.isEmpty()) {
                Toast.makeText(this, "input last name correctly", Toast.LENGTH_LONG).show()
                return false
            }
        }catch (e: Exception){
            Toast.makeText(this, "input age correctly", Toast.LENGTH_SHORT).show()
            return false
        }

        Toast.makeText(this, "info saved successfully", Toast.LENGTH_SHORT).show()
        return true

    }

    private fun clearInput() {
        binding.edEmail.text?.clear()
        binding.edUsername.text?.clear()
        binding.edFirstName.text?.clear()
        binding.edLastName.text?.clear()
        binding.edAge.text?.clear()
    }


}





