package engineTester;


import io.Loader;
import io.Model;
import io.Renderer;
import io.Window;
import org.lwjgl.glfw.GLFW;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");

        // Create Window
        Window.createWindow();
        long window = Window.getWindow();
        // Create Renderer
        Renderer renderer = new Renderer();


        // Data
        float[] positions = {
                0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f
        };

        // Create Model
        Model triangle = Loader.dataToModel(positions);

        // Clear

        // Render on window
        while(!GLFW.glfwWindowShouldClose(window)){
            GLFW.glfwPollEvents();
            renderer.clear();
            renderer.render(triangle);

            GLFW.glfwSwapBuffers(window);   // !@#!@#!@# remember to add!!!  !@#!@# Order important prob
        }
        System.out.println("TERMINATED");

        Window.terminateWindow();
    }

}
