package com.github.zzk.myopengldemo.render;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * @Project MyOpenGLDemo
 * @Package com.github.zzk.myopengldemo.render
 * @Author zhuangzaiku
 * @Date 2018/9/19
 */
public class OpenGLRender implements GLSurfaceView.Renderer {
    private IRender mRender;

    public OpenGLRender(IRender render) {
        this.mRender = render;
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        gl10.glViewport(0, 0 ,i , i1);

    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        mRender.draw(gl10);


    }
}
