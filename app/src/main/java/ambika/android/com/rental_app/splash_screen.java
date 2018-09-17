package ambika.android.com.rental_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class splash_screen extends AppCompatActivity {

    private RelativeLayout loginDetails,extraButtons;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            loginDetails.setVisibility(View.VISIBLE);
            extraButtons.setVisibility(View.VISIBLE);
        }
    };
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        loginDetails = (RelativeLayout) findViewById(R.id.loginDetails);
        extraButtons = (RelativeLayout) findViewById(R.id.extraButton);
        handler.postDelayed(runnable,2000);
        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(splash_screen.this,home.class);
                startActivity(in);
            }
        });
    }
}
