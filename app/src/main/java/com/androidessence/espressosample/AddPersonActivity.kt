package com.androidessence.espressosample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity

/**
 * Extension method on an edit text that checks if it is empty and sets an error if it is.
 */
fun TextInputEditText.hasError(message: String): Boolean {
    if (this.text.toString().isNullOrBlank()) {
        this.error = message
        return true
    }

    return false
}

class AddPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        val firstName = findViewById(R.id.first_name) as TextInputEditText
        val lastName = findViewById(R.id.last_name) as TextInputEditText
        val age = findViewById(R.id.age) as TextInputEditText
        val emailAddress = findViewById(R.id.email_address) as TextInputEditText
        val submit = findViewById(R.id.submit)

        submit.setOnClickListener {
            val invalid = firstName.hasError(getString(R.string.err_first_name_blank))
                    || lastName.hasError(getString(R.string.err_last_name_blank))
                    || age.hasError(getString(R.string.err_age_blank))
                    || emailAddress.hasError(getString(R.string.err_email_address_blank))

            if (!invalid) {
                val person = Person(
                        firstName.text.toString(),
                        lastName.text.toString(),
                        age.text.toString().toInt(),
                        emailAddress.text.toString())

                val data = Intent()
                data.putExtra(MainActivity.PERSON, person)
                setResult(Activity.RESULT_OK, data)
                finish()
            }
        }
    }
}
