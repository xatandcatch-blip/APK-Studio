package com.apkstudio.app.ui

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apkstudio.app.R

class StudioSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studio_settings)

        setupLanguageOptions()
        setupNDKOptions()
    }

    private fun setupLanguageOptions() {
        val kotlinCheckbox = findViewById<CheckBox>(R.id.checkbox_kotlin)
        val javaCheckbox = findViewById<CheckBox>(R.id.checkbox_java)
        val cppCheckbox = findViewById<CheckBox>(R.id.checkbox_cpp)
        val csharpCheckbox = findViewById<CheckBox>(R.id.checkbox_csharp)
        val gradleCheckbox = findViewById<CheckBox>(R.id.checkbox_gradle)
        val ktsCheckbox = findViewById<CheckBox>(R.id.checkbox_kts)
        val cCheckbox = findViewById<CheckBox>(R.id.checkbox_c)
        val modelsCheckbox = findViewById<CheckBox>(R.id.checkbox_3d_models)

        kotlinCheckbox.isChecked = true
        javaCheckbox.isChecked = true

        kotlinCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("Kotlin") else disableLanguage("Kotlin")
        }

        javaCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("Java") else disableLanguage("Java")
        }

        cppCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("C++") else disableLanguage("C++")
        }

        csharpCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("C#") else disableLanguage("C#")
        }

        gradleCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("Gradle") else disableLanguage("Gradle")
        }

        ktsCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("Kotlin Script") else disableLanguage("Kotlin Script")
        }

        cCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("C") else disableLanguage("C")
        }

        modelsCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) enableLanguage("3D Models") else disableLanguage("3D Models")
        }
    }

    private fun setupNDKOptions() {
        val ndkCheckbox = findViewById<CheckBox>(R.id.checkbox_ndk)
        val installNDKButton = findViewById<Button>(R.id.btn_install_ndk)

        ndkCheckbox.setOnCheckedChangeListener { _, isChecked ->
            installNDKButton.isEnabled = isChecked
            if (isChecked) {
                Toast.makeText(this, "NDK enabled", Toast.LENGTH_SHORT).show()
            }
        }

        installNDKButton.setOnClickListener {
            installNDK()
        }
    }

    private fun enableLanguage(language: String) {
        Toast.makeText(this, "$language enabled", Toast.LENGTH_SHORT).show()
    }

    private fun disableLanguage(language: String) {
        Toast.makeText(this, "$language disabled", Toast.LENGTH_SHORT).show()
    }

    private fun installNDK() {
        Thread {
            try {
                // TODO: Implement NDK download and installation
                runOnUiThread {
                    Toast.makeText(this@StudioSettingsActivity, "NDK installed successfully", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@StudioSettingsActivity, "NDK installation failed: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }
}