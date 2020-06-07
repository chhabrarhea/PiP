package com.example.pip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.app.PictureInPictureParams;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity   {
    VideoView vv;
    public void enterPIP(View view)
    {
        Rational rational = new Rational(vv.getWidth(),
                vv.getHeight());
        PictureInPictureParams.Builder
                pip_Builder
                = new PictureInPictureParams
                .Builder();
        pip_Builder.setAspectRatio(rational).build();;
        enterPictureInPictureMode(pip_Builder.build());
        getSupportActionBar().hide();
        view.setVisibility(View.INVISIBLE);
        vv.setMediaController(null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vv=(VideoView)findViewById(R.id.videoView);
        vv.setVideoPath("android.resource://" +getPackageName()+"/"+R.raw.c1);
        MediaController mc=new MediaController(this);
        mc.setAnchorView(vv);
        vv.setMediaController(mc);
        vv.start();
        Button b=findViewById(R.id.button);

        if(!isInPictureInPictureMode())
        {
            getSupportActionBar().show();
            b.setVisibility(View.VISIBLE);
            vv.setMediaController(mc);
        }




    }


}
