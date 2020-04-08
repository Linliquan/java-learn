package DadAndChild;

public class Child extends Dad {



    public void show(){
        System.out.println("C - show");
    }

    public static void main(String[] args) {
        Child dad = new Child();
        dad.test();

    }
}
