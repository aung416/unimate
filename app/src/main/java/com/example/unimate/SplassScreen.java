package com.example.unimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.animation.Animation;

public class SplassScreen extends AppCompatActivity {
   ImageView logo_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splass_screen);

        logo_pic = findViewById(R.id.bfmstu_pic);
        Animation animation = new AnimationUtils().loadAnimation(this,R.anim.fadein);
        logo_pic.startAnimation(animation);

        SessionManager sessionManager = new SessionManager(this);
       boolean b =sessionManager.checkSession();


        /*1. the Handler is used to delay the execution of the code within the run() method by
        2000 milliseconds (2 seconds).
        2. A Handler is an Android class that allows you to send and process Message and Runnable objects
         associated with a thread's message queue.
        3.Calls the postDelayed method on the Handler instance. This method is used to post a Runnable to
          the message queue of the Handler. The Runnable represents the code that will be executed after
          a specified delay.
         */
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               if(b)
               {
                   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                   startActivity(intent);
               }
               else
               {
                   Intent intent = new Intent(getApplicationContext(), Login.class);
                   startActivity(intent);
               }
           }
       }, 2000);
/*   if we are executing this code within an Activity, we can also use 'this'  as the context:
        Intent intent;
        if (b) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, Login.class);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 2000);
*/

    }
}