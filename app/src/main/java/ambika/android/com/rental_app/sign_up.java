package ambika.android.com.rental_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up extends AppCompatActivity {
    EditText email,etpassword;
    Button signupbtn;
    ProgressDialog progress;
    FirebaseAuth newuser;
    DatabaseReference myref;
    DatabaseReference ref;
    FirebaseDatabase database;
    FirebaseUser user;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = (EditText)findViewById(R.id.emailBox);
        etpassword = (EditText)findViewById(R.id.passwordBox);
        signupbtn = (Button)findViewById(R.id.signUpButton);
        progress = new ProgressDialog(this);
        newuser = FirebaseAuth.getInstance();
        //user = FirebaseAuth.getInstance().getCurrentUser();
        //id = user.getUid();
        //database = FirebaseDatabase.getInstance();
        //myref = database.getReferenceFromUrl("https://rentalappauth.firebaseio.com/").child(id);
        //ref = database.getReferenceFromUrl("https://rentalappauth.firebaseio.com/");
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = email.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                if(TextUtils.isEmpty(emailid)|| TextUtils.isEmpty(password)){
                    Toast.makeText(sign_up.this, "Invalid details", Toast.LENGTH_LONG).show();
                    return;

                }
                progress.setMessage("Registering User....");
                progress.show();
                newuser.createUserWithEmailAndPassword(emailid, password).addOnCompleteListener(sign_up.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(sign_up.this , "Successfull", Toast.LENGTH_LONG).show();
                            Intent intent1 = new Intent();
                            intent1.setClass(sign_up.this, MainActivity.class);
                            startActivity(intent1);
                            finish();
                        }
                        else{
                            Toast.makeText(sign_up.this , "Not Successfull - Check Validity of Email and Password " , Toast.LENGTH_LONG).show();
                        }

                    }
                });


            }
        });

    }
}
