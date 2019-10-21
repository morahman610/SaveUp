package com.example.saveup.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.saveup.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private val TAG = "SignUpActivity"
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
    }

    fun createUser(view: View) {

        val signupEmail = signupEmail.text.toString()
        val signupPassword = signupPassword.text.toString()

        if (signupEmail.isEmpty() || signupPassword.isEmpty()) {
            Toast.makeText(this,"Please enter valid email and password", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(signupEmail, signupPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this,"User has been successfully created. You can now log in.", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "createUserWithEmail:success")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

                // ...
            }
    }

    fun loginIntent(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
