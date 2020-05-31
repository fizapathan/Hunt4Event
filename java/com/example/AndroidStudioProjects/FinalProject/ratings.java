package com.example.AndroidStudioProjects.FinalProject;

/**
 * Created by Nazim Patham on 24-03-2018.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

public class ratings extends AppCompatActivity {
    RatingBar rt1;
    TextView tt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        rt1=(RatingBar)findViewById(R.id.rb1);
        tt1=(TextView)findViewById(R.id.txv3);

        rt1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(ratings.this, ""+v, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {
        Toast.makeText(ratings.this,"Thank for Rating!", Toast.LENGTH_SHORT).show();
    }
}
