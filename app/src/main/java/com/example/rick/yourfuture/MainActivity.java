 package com.example.rick.yourfuture;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PrivateKey;
import java.util.Random;

 public class MainActivity extends AppCompatActivity {

     TextView textView;

     private SensorManager sm;

     private float acelVal;  // CURRENT ACCELERATION VALUE AND GRAVITY.
     private float acelLast; // LAST ACCELERATION VALUE AND GRAVITY.
     private float shake; // ACCELERATION VALUE differ FROM GRAVITY.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button RollButton;
        RollButton = findViewById(R.id.RollButton);

        Button ResetButton;
        ResetButton = findViewById(R.id.ResetButton);


        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE );
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;







        textView = (TextView)  findViewById(R.id.futureText);




        final ImageView leftImage = findViewById(R.id.image_leftImage);

        final ImageView rightImage = findViewById(R.id.image_rightImage);

        final int[] futureArray = {R.drawable.alexender, R.drawable.allen, R.drawable.ann, R.drawable.annabelle, R.drawable.goldfish, R.drawable.isa, R.drawable.james, R.drawable.jemima, R.drawable.leica, R.drawable.leila, R.drawable.micheal, R.drawable.podeye, R.drawable.samy, R.drawable.seby, R.drawable.winnie, R.drawable.yoah };
        final String[] textArray = {"ces deux personnes vont jouer au basket ensemble la semaine prochaine","ces deux personnes vont faire du Go-Kart demain","ces deux personnes vont devenir riche en gagnant a la loterie","la semaine prochaine en haiti ils vont rencontrer des zombies","la prochaine pizza qu'il vont commander sera empoisonner ","Ils vont rencontrer des espions russes travaillant pour vladimir Poutine","ils vont inventer la machine a voyager dans le temps en 2036","dans 10 ans ils seront les dirigeant de walmart et mcDonald","ils vont recevoir un nouveaux chiots demain","ils vont me donner 1000 dollars maintenant"};




        RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* generate string with 6 symbols */



                Log.d("YourFuture", "The button had been pressed");

                Random RandomNumberGenerator = new Random();

                int number = RandomNumberGenerator.nextInt(16);



                Log.d("YourFuture", "The random number is: " + number);

                leftImage.setImageResource(futureArray[number]);

                number = RandomNumberGenerator.nextInt(16);

                rightImage.setImageResource(futureArray[number]);

                number = RandomNumberGenerator.nextInt(10);

                textView.setText(textArray[number]);
                }


        });
        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Press the button below" );
                leftImage.setImageDrawable(Drawable.createFromPath("@drawable/smurf"));
                rightImage.setImageDrawable(Drawable.createFromPath("@drawable/smurf"));
                }
        });









        }
        private final SensorEventListener sensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {



                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                acelLast = acelVal;
                acelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));
                float delta  = acelVal - acelLast;
                shake = shake * 0.9f + delta;


                if (shake > 1) {   final int[] futureArray = {R.drawable.alexender, R.drawable.allen, R.drawable.ann, R.drawable.annabelle, R.drawable.goldfish, R.drawable.isa, R.drawable.james, R.drawable.jemima, R.drawable.leica, R.drawable.leila, R.drawable.micheal, R.drawable.podeye, R.drawable.samy, R.drawable.seby, R.drawable.winnie, R.drawable.yoah };
                    final String[] textArray = {"ces deux personnes vont jouer au basket ensemble la semaine prochaine","ces deux personnes vont faire du Go-Kart demain","ces deux personnes vont devenir riche en gagnant a la loterie","la semaine prochaine en haiti ils vont rencontrer des zombies","la prochaine pizza qu'il vont commander sera empoisonner ","Ils vont rencontrer des espions russes travaillant pour vladimir Poutine","ils vont inventer la machine a voyager dans le temps en 2036","dans 10 ans ils seront les dirigeant de walmart et mcDonald","ils vont recevoir un nouveaux chiots demain","ils vont me donner 1000 dollars maintenant"}; Random RandomNumberGenerator = new Random();
                    final ImageView leftImage = findViewById(R.id.image_leftImage);

                    final ImageView rightImage = findViewById(R.id.image_rightImage);
                    int number = RandomNumberGenerator.nextInt(16);



                    Log.d("YourFuture", "The random number is: " + number);


                    leftImage.setImageResource(futureArray[number]);

                    number = RandomNumberGenerator.nextInt(16);

                    rightImage.setImageResource(futureArray[number]);

                    number = RandomNumberGenerator.nextInt(10);

                    textView.setText(textArray[number]);



                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };




        }




