package com.gameshock.theflyingfish.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.gameshock.theflyingfish.R;
import com.gameshock.theflyingfish.databinding.ActivityGetStartedBinding;

public class GetStartedActivity extends AppCompatActivity {

    ActivityGetStartedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //startanimation
        startZoomAnimation();

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GetStartedActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void startZoomAnimation() {
        // Zoom in animation
        ScaleAnimation zoomInAnimation = new ScaleAnimation(1.1f, 1f, 1.1f, 1f,
                Animation.RELATIVE_TO_SELF, 0.2f, Animation.RELATIVE_TO_SELF, 0.2f);
        zoomInAnimation.setDuration(1000);
        zoomInAnimation.setRepeatCount(1);
        zoomInAnimation.setRepeatMode(Animation.REVERSE);

        // Zoom out animation
        ScaleAnimation zoomOutAnimation = new ScaleAnimation(1.1f, 1f, 1.1f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomOutAnimation.setDuration(1000);
        zoomOutAnimation.setRepeatCount(1);
        zoomOutAnimation.setRepeatMode(Animation.REVERSE);

        // Create the animation set
        Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startZoomAnimation(); // Restart the animation
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };

        zoomInAnimation.setAnimationListener(animationListener);
        zoomOutAnimation.setAnimationListener(animationListener);

        // Start the zoom in and zoom out animations
        binding.layout1.startAnimation(zoomInAnimation);
        binding.layout1.startAnimation(zoomOutAnimation);
    }
}