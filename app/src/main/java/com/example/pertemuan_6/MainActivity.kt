package com.example.pertemuan_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pertemuan_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var provinces: Array<String>
    private val countries = arrayOf(
        "Indonesia",
        "United States",
        "United Kingdom",
        "Germany",
        "France",
        "Australia",
        "Japan",
        "China",
        "Brazil",
        "Canada"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        provinces = resources.getStringArray(R.array.provinces)

        with(binding) {
            val adapterCountry = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, countries
            )

            adapterCountry.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinnerCountry.adapter = adapterCountry

            val adapterProvinces = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, provinces
            )

            adapterProvinces.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinnerProvinces.adapter = adapterProvinces

            var selectedDate = ""
            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
                // Gunakan selectedDate sesuai kebutuhan Anda
            }

            var selectedDate2 = ""
            datePicker2.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                selectedDate2 = "$dayOfMonth/${monthOfYear + 1}/$year"
                Toast.makeText(this@MainActivity, selectedDate2, Toast.LENGTH_SHORT).show()
                // Gunakan selectedDate sesuai kebutuhan Anda
            }

            var selectedTime = ""
            timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
                // Gunakan selectedTime sesuai kebutuhan Anda

            }

            var selectedTime2 = ""
            timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
                selectedTime2 = String.format("%02d:%02d", hourOfDay, minute)
                Toast.makeText(this@MainActivity, selectedTime2, Toast.LENGTH_SHORT).show()
                // Gunakan selectedTime sesuai kebutuhan Anda

            }
        }
    }
}
