package net.larntech.firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fStore: FirebaseFirestore;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fStore = FirebaseFirestore.getInstance();
        addUserBtn.setOnClickListener {

            var userName:String = edUsername.text.trim().toString();
            var userEmail:String = edUserEmail.text.trim().toString();
            var userPhone:String = edPhoneNumber.text.trim().toString();

            addUserToFireStore(userName,userEmail,userPhone);


        }
    }

    fun  addUserToFireStore(username:String,useremail:String,userphone:String){

        val user = hashMapOf("userName" to username, "userEmail" to useremail, "userPhone" to userphone);

        fStore.collection("users")
            .add(user as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this,"Successful ", Toast.LENGTH_LONG).show();
            }
            .addOnFailureListener {exception ->
                Toast.makeText(this,"Failed to add ", Toast.LENGTH_LONG).show();

            }


    }
}