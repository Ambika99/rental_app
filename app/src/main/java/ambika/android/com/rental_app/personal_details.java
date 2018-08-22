package ambika.android.com.rental_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class personal_details extends AppCompatActivity {
    FirebaseAuth newuser;
    DatabaseReference myref;
    DatabaseReference ref;
    FirebaseDatabase database;
    FirebaseUser user;
    String id,mobile,cust_name;
    EditText name,num;
    Button btndone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        name = (EditText)findViewById(R.id.nameBox);
        num = (EditText)findViewById(R.id.numberBox);
        btndone = (Button)findViewById(R.id.btndone);
        newuser = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        id = user.getUid();
        database = FirebaseDatabase.getInstance();
        myref = database.getReferenceFromUrl("https://rentalappauth.firebaseio.com/").child(id);
        ref = database.getReferenceFromUrl("https://rentalappauth.firebaseio.com/");

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile= num.getText().toString().trim();
                cust_name = name.getText().toString().trim();
                if(TextUtils.isEmpty(mobile)||TextUtils.isEmpty(cust_name)||mobile.length()!=10){
                    Toast.makeText(personal_details.this,"Enter valid details",Toast.LENGTH_LONG).show();
                }
                else{
                    myref.child(cust_name).setValue(cust_name);
                    myref.child("Mobile Number").setValue(mobile);
                    Intent done = new Intent();
                    done.setClass(personal_details.this,first_page.class);
                    startActivity(done);

                }

            }
        });

    }
}
