package ambika.android.com.rental_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.common.oob.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText email,etpassword;
    Button btnlogin;
    FirebaseAuth login;
    ProgressDialog progress;
    FirebaseUser user;
    String id;
    FirebaseDatabase database;
    DatabaseReference myref;

    RelativeLayout loginDetails,extraButtons;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            loginDetails.setVisibility(View.VISIBLE);
            extraButtons.setVisibility(View.VISIBLE);
        }
    };
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.usernameBox);
        etpassword = (EditText)findViewById(R.id.passwordBox);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        loginDetails = (RelativeLayout) findViewById(R.id.loginDetails);
        extraButtons = (RelativeLayout) findViewById(R.id.extraButton);
        handler.postDelayed(runnable,2000);
        signUp = (Button) findViewById(R.id.signUpButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,sign_up.class);
                startActivity(in);
            }
        });
        progress = new ProgressDialog(this);
        login = FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = email.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                if(TextUtils.isEmpty(emailid)|| TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Invalid details", Toast.LENGTH_LONG).show();
                    return;

                }
                progress.setMessage("Logging In User....");
                progress.show();
                login.signInWithEmailAndPassword(emailid, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if(task.isSuccessful()){
                            Intent intent1 = new Intent();
                            intent1.setClass(MainActivity.this, personal_details.class);
                            startActivity(intent1);
                            finish();
                        }
                        else{
                            Toast.makeText(MainActivity.this , "Not Successful - Recheck Login Credentials" , Toast.LENGTH_LONG).show();
                        }

                    }
                });


            }
        });


    }

    }
