package io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLUtil;
import org.lwjgl.system.Callback;

public class Window {
    private static long window;
    private static Callback debugCallback;

    public static void createWindow(){
        // Creates a window

        // Init
        if(!GLFW.glfwInit()){
            throw new IllegalStateException("ERROR: could not GLFW.glfwInit()");
        }

        // Hints  *()*() Can't remember
        // Hint opengl version
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR,3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR,2);
        // Hint compatibility (profile, forward compat)
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE,GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT,GLFW.GLFW_TRUE);
        // Hint to hide initially
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE,GLFW.GLFW_FALSE);
        // Hint debug
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_DEBUG_CONTEXT, GLFW.GLFW_TRUE);


        // Actually create window
        window = GLFW.glfwCreateWindow(500, 500, "thinMatrix4", 0, 0);
        if(window == 0){
            throw new IllegalStateException("ERROR: during GLFW.glfwCreateWindow");
        }

        // Context and Capabilities
        GLFW.glfwMakeContextCurrent(window);    // create context for window
        GL.createCapabilities();    // find all the opengl stuff to give capabilities

        // Debugging enable
        GL11.glEnable(org.lwjgl.opengl.KHRDebug.GL_DEBUG_OUTPUT_SYNCHRONOUS);
        debugCallback = GLUtil.setupDebugMessageCallback();

        // Position window
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window,vidMode.width()/2,vidMode.height()/2);

        // Window show
        GLFW.glfwShowWindow(window);
    }

    public static void terminateWindow(){
        // Termination
        GLFW.glfwTerminate();
    }

    // GETTERS
    public static long getWindow() {
        return window;
    }
}
