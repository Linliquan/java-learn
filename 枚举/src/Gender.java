public enum Gender {
    MAN(1),
    WOMAN(2);
    private int id;

    private Gender(int id){
        this.id = id;
    }

    public void show(){
        System.out.println(id);
    }

    public static void main(String[] args) {
            Gender g = Gender.MAN;
        System.out.println(g.id);
    }

}
