package io;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static List<Integer> vaos = new ArrayList<Integer>();
    private static List<Integer> vbos = new ArrayList<Integer>();

    public static Model dataToModel(float[] data){
        // Create VAO
        int vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);
        vaos.add(vao);

        // Create Buffer (VBO) for actual data
        int vbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER,data, GL15.GL_STATIC_DRAW);      //!@#!@#!@# What happens if data is not a float buffer
        // vertex attribute pointer
        GL30.glVertexAttribPointer(0,3, GL11.GL_FLOAT,false,0,0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,0);
        vbos.add(vbo);

        // Create model
        int count = data.length/3;
        Model model = new Model(vao, count);

        return model;
    }

    // data

    // clean up

    // PRIVATE HELPER METHODS
    // To float
    private static FloatBuffer toFloatBuffer(float[] data){
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }
}
