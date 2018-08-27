package ambika.android.com.rental_app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

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