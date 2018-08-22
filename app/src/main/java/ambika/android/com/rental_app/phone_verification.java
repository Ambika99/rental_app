package ambika.android.com.rental_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class phone_verification extends AppCompatActivity {
    EditText num,otp;
    TextView otplabel;
    Button signupbtn,verify;
    FirebaseAuth phoneauth;
    String codesent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);
        num = (EditText)findViewById(R.id.numberBox);
        otp = (EditText)findViewById(R.id.otpBox);
        otplabel= (TextView) findViewById(R.id.otp);
        signupbtn = (Button)findViewById(R.id.signUpButton);
        verify = (Button)findViewById(R.id.verify);
        phoneauth = FirebaseAuth.getInstance();
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendverificationcode();
                otplabel.setVisibility(View.VISIBLE);
                otp.setVisibility(View.VISIBLE);
                signupbtn.setVisibility(View.VISIBLE);

            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifysignincode();

            }
        });


    }
    private  void verifysignincode(){
        String code = otp.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codesent, code);
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        phoneauth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent signup = new Intent();
                            signup.setClass(phone_verification.this,sign_up.class);
                            startActivity(signup);

                        } else {


                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(phone_verification.this, "Incoorect Verification Code", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                });
    }
    private void sendverificationcode(){
        String phoneNumber;
        phoneNumber = num.getText().toString();
        if(phoneNumber.isEmpty()){
            num.setError("Phone number is required");
            num.requestFocus();
            return;
        }
        if(phoneNumber.length()<10){
            num.setError("Enter valid phone number");
            num.requestFocus();
            return;
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            codesent =s;
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }
    };

}
