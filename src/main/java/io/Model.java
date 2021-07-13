package io;

public class Model {
    private int vertexCount;
    private int vao;

    public Model(int vao, int count){
        this.vao = vao;
        this.vertexCount = count;
    }

    // GETTERS
    public int getVertexCount(){
        return this.vertexCount;
    }
    public int getVAO(){ return this.vao; }
}
