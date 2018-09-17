package ambika.android.com.rental_app;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends FragmentPagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    private static int NUM_ITEMS = 3;
    FragmentPagerAdapter adapterViewPager;
    public SliderAdapter(android.support.v4.app.FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public int getCount() {

        return NUM_ITEMS;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Scooter.newInstance("Scooter", R.drawable.scooter);
            case 1:
                return Bike.newInstance("Fragment 2", R.drawable.bike);
            case 2:
                return RoyalEnfield.newInstance("Fragment 3", R.drawable.royal_enfield);
            default:
                return null;
        }
    }





}