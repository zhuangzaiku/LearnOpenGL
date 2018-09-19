package com.github.zzk.myopengldemo.render.instance;


import com.github.zzk.myopengldemo.render.IRender;
import com.github.zzk.myopengldemo.render.RenderBase;

import javax.microedition.khronos.opengles.GL10;

/**
 * @Project MyOpenGLDemo
 * @Package com.github.zzk.myopengldemo.render
 * @Author zhuangzaiku
 * @Date 2018/9/19
 */
public class Line extends RenderBase {

    @Override
    public void draw(GL10 gl) {
        super.draw(gl);
        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glLineWidth(8.f);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0 , -1f);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 3 * 4, vertex);

        int frame = frameIndex % 100;
        if(frame <= 30) {
            //首尾不衔接
            gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 4);
        } else if(frame <= 60) {
            //首尾衔接
            gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);
        } else {
            //分离的线段
            gl.glDrawArrays(GL10.GL_LINES, 0, 4);
        }


        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    @Override
    protected float[] getVertexArray() {
        return new float[] {
                -0.8f,  -0.4f * 1.732f, 0.0f,
                 0.8f,  -0.4f * 1.732f, 0.0f,
                 0.0f,   0.4f * 1.732f, 0.0f,
                 0.0f,  -0.0f * 1.732f, 0.0f
        };
    }
}
