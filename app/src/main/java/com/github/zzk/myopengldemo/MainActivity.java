package com.github.zzk.myopengldemo;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.zzk.myopengldemo.render.instance.Line;
import com.github.zzk.myopengldemo.render.OpenGLRender;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.glSurfaceView)
    GLSurfaceView mGLsurfaceView;

    private OpenGLRender mRender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRender = new OpenGLRender(new Line());
        mGLsurfaceView.setRenderer(mRender);
        mGLsurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLsurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLsurfaceView.onPause();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
