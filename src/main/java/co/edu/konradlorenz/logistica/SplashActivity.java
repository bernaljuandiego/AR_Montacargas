package co.edu.konradlorenz.logistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.translate_in_vertical);
        CardView l = (CardView) findViewById(R.id.card);
        l.startAnimation(anim1);
        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_in_horizontal);
                ImageView j = (ImageView) findViewById(R.id.cargadorImagen);
                j.setAlpha(1.0f);
                j.startAnimation(anim2);
                anim2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Animation anim3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_out_horizontal);
                        anim3.setStartOffset(1000);
                        ImageView j = (ImageView) findViewById(R.id.cargadorImagen);
                        j.startAnimation(anim3);
                        anim3.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                ImageView j = (ImageView) findViewById(R.id.cargadorImagen);
                                j.setAlpha(0.0f);
                                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                                SplashActivity.this.finish();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}