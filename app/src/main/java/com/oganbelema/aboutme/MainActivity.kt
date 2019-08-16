package com.oganbelema.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.oganbelema.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName by lazy {
        MyName(name = getString(R.string.name))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            binding.apply {
                binding.myName?.nickname = nicknameEdit.text.toString()
                // Invalidate all binding expressions and request a new rebind to refresh UI
                invalidateAll()
                nicknameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
            }

            //Hide keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)
        }

    }


}
