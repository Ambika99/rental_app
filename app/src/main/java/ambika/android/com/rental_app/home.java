package ambika.android.com.rental_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    private Button bookButton,checkButton,optionsButton,signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bookButton = (Button) findViewById(R.id.bookButton);
        checkButton = (Button) findViewById(R.id.checkButton);
        optionsButton = (Button) findViewById(R.id.optionsButton);
        signOutButton = (Button) findViewById(R.id.signOutButton);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(home.this,MainActivity.class);
                startActivity(in);
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(home.this,my_rides.class);
                startActivity(in);
            }
        });
        optionsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(home.this,options.class);
                startActivity(in);
            }
        });
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(home.this,MainActivity.class);
                startActivity(in);
            }

        });


    }
}
