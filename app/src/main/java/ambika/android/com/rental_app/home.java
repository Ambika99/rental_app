package ambika.android.com.rental_app;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.ramotion.foldingcell.FoldingCell;

public class home extends AppCompatActivity {

    private CardView bookButton,checkButton,contactUsButton,aboutUsButton,signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bookButton = (CardView) findViewById(R.id.bookButton);
        checkButton = (CardView) findViewById(R.id.checkButton);
        contactUsButton = (CardView) findViewById(R.id.contactUsButton);
        aboutUsButton = (CardView) findViewById(R.id.aboutUsButton);
        signOutButton = (CardView) findViewById(R.id.signOutButton);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(home.this,MainActivity.class);
                startActivity(in);
            }
        });
        contactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =  new Intent(home.this,ContactUs.class);
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
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(home.this,about_us.class);
                startActivity(in);
            }
        });
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(home.this,splash_screen.class);
                startActivity(in);
            }

        });


    }
}