package ambika.android.com.rental_app;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class front extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;

    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggleButton;

    private Button mNextBtn;
    private Button mPrevBtn;

    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mSlideViewPager = findViewById(R.id.viewPager);
        mDotsLayout = findViewById(R.id.nav);
        mPrevBtn = findViewById(R.id.prev);
        mNextBtn = findViewById(R.id.next);
        sliderAdapter = new SliderAdapter(getSupportFragmentManager());
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        mPrevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotsLayout.removeAllViews();
        for (int i=0;i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(25);
            mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));
            mDotsLayout.addView(mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextSize(35);
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;
            if (position==0){
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(false);
                mPrevBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
            }
            else if (position==mDots.length-1){
                mPrevBtn.setEnabled(true);
                mNextBtn.setEnabled(false);
                mNextBtn.setVisibility(View.INVISIBLE);
                mPrevBtn.setText("Back");
            }
            else {
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(true);
                mPrevBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mPrevBtn.setText("Back");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }



    };
}
