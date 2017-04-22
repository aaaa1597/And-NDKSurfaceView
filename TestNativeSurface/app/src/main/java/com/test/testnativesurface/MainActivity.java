package com.test.testnativesurface;

import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NativeFunc.create(1);
        SurfaceView surface = (SurfaceView)findViewById(R.id.testnativesurfaveview);
        surface.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        surface.setZOrderOnTop(true);
        surface.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                NativeFunc.surfaceCreated(1, holder.getSurface());
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                NativeFunc.surfaceChanged(1, width, height);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                NativeFunc.surfaceDestroyed(1);
            }
        });
    }
}
