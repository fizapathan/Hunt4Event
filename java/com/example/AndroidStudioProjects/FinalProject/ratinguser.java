package com.example.AndroidStudioProjects.FinalProject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitika.FinalProject.R;

/**
 * Created by Nazim Patham on 24-03-2018.
 */

public class ratinguser extends AppCompatActivity {
    TextView tu1;
    RatingBar rtb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratinguser);

        rtb1=(RatingBar)findViewById(R.id.rb1);
        tu1=(TextView)findViewById(R.id.txv3);

        rtb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(ratinguser.this, ""+v, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {
        Toast.makeText(ratinguser.this, "Thanks for Rating!", Toast.LENGTH_SHORT).show();

    }
}
