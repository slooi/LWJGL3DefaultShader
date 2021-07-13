package io.archive;


import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static List<Integer> vaos = new ArrayList<Integer>();
    private static List<Integer> vbos = new ArrayList<Integer>();


    public static Model dataToModel(float[] data, int[] indices){

        // Create VAO
        int vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);
        vaos.add(vao);

        // Create Buffer (VBO) for indices (arrangement of data)
        int vbo2 = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER,vbo2);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER,toIntBuffer(indices),GL15.GL_STATIC_DRAW); //!@#!@#!@#!@# what happens if data is not int buffer
        // !#@!@#!@#!@# do I need a vertexAttribPointer and why not?
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER,0);
        vbos.add(vbo2);

        // Create Buffer (VBO) for actual data
        int vbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER,toFloatBuffer(data), GL15.GL_STATIC_DRAW);      //!@#!@#!@# What happens if data is not a float buffer
        // vertex attribute pointer
        GL30.glVertexAttribPointer(0,3, GL11.GL_FLOAT,false,0,0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,0);
        vbos.add(vbo);


        // Create model
        int count = indices.length;
        Model model = new Model(vao, count);

        return model;
    }


    // data

    // clean up

    // PRIVATE HELPER METHODS

    private static IntBuffer toIntBuffer(int[] data){
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    // float to
    private static FloatBuffer toFloatBuffer(float[] data){
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

}
