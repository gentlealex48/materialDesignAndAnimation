package com.example.admin.debbugingandmasterialdesign;


import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Switch swVisible,swInvisible;
    ImageView imageView;
    Animation blink;
    TextView tvAnim,tvAnimEx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swVisible = findViewById(R.id.switchVisible);
        swInvisible = findViewById(R.id.switchAnimate);
        imageView = findViewById(R.id.imageView);
        tvAnim = findViewById(R.id.tvAnimation);
        tvAnimEx = findViewById(R.id.tvAnimExplian);
        init();
    }


    private void init() {
        imageView.setVisibility(View.VISIBLE);
        swInvisible.setChecked(false);
        swVisible.setChecked(true);
        swVisible.setOnCheckedChangeListener(this);
        swInvisible.setOnCheckedChangeListener(this);
        if (BuildConfig.FLAVOR.equals("Rotation")) {
            blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            tvAnim.setText("Rotate");
            tvAnimEx.setText("Makes the image to rotate clockwise");
        } if (BuildConfig.FLAVOR.equals("Blinking")) {
            blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
            tvAnim.setText("Blink");
            tvAnimEx.setText("Makes the image to blink");
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.switchVisible:
                if (isChecked) {
                    imageView.setVisibility(View.VISIBLE);
                }else {
                    imageView.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.switchAnimate:
                if (isChecked) {
                    imageView.startAnimation(blink);
                } else {
                    imageView.setAnimation(null);
                }
                break;
        }

    }
}
