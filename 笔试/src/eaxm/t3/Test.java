package eaxm.t3;

public class Test {
    public static void main(String[] args) {
        Rect rect = new Rect();
        rect.setL(2);
        rect.setWidth(3);
        rect.setH(4);

        int l = rect.getLength();
        int w = rect.getWidth();
        int h = rect.getHeight();

        System.out.println("底面积："+ rect.getArea(l,w));
        System.out.println("体积："+ rect.getV(l,w,h));


    }
}
