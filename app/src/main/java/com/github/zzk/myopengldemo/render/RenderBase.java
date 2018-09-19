package com.github.zzk.myopengldemo.render;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * @Project MyOpenGLDemo
 * @Package com.github.zzk.myopengldemo.render
 * @Author zhuangzaiku
 * @Date 2018/9/19
 */
public abstract class RenderBase implements IRender{

    protected float[] vertexArray;
    protected ByteBuffer vbb;
    protected FloatBuffer vertex;
    protected int frameIndex;


    public RenderBase() {
        vertexArray = getVertexArray();
        if(vertexArray == null || vertexArray.length == 0) {
            throw new RuntimeException("vertex should not be null!");
        }
        vbb = ByteBuffer.allocateDirect(vertexArray.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertex = vbb.asFloatBuffer();
        vertex.put(vertexArray);
        vertex.position(0);

    }

    /**
     * 子类定义定点坐标
     * @return
     */
    protected abstract float[] getVertexArray();

    @Override
    public void draw(GL10 gl) {
        frameIndex++;
    }
}
