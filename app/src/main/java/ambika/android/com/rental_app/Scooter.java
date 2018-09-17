package ambika.android.com.rental_app;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Scooter extends android.support.v4.app.Fragment {
    private String title;
    private int image;

    public static Scooter newInstance(String title, int image) {

        Scooter fragment = new Scooter();
        Bundle args = new Bundle();
        args.putInt("image",image);
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = getArguments().getInt("image",0);
        title = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_scooter,container,false);
        ImageView imageView = view.findViewById(R.id.slideImageView);
        imageView.setImageResource(image);
        TextView heading = view.findViewById(R.id.slideHeading);
        heading.setText(title);
        Button button = view.findViewById(R.id.selectBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),scooter_price.class);
                startActivity(intent);
            }
        });
        return view;
    }
}