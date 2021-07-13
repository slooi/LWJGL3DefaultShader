package io;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer {

    public void render(Model model){
        // Enable to allow model rendering
        GL30.glBindVertexArray(model.getVAO());
        GL20.glEnableVertexAttribArray(0);

        // Render
        GL11.glDrawArrays(GL11.GL_TRIANGLES,0,model.getVertexCount());

        // Clean up
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    }
    public void clear(){
        GL11.glClearColor(0f,0.8f,.6f,1f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

}
