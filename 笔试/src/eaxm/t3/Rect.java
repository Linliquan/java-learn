package eaxm.t3;

public class Rect extends Rectangular {
    private int length;
    private int width;
    private int height;


    public void setL(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setH(int height){
        this.height = height;
    }

    public int getLength(){
        return length;
    }

    public  int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getV(int length,int width,int height){
        return length*width*height;
    }


}
