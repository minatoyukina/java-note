package effective_java;

public enum Singleton {

    INSTANCE(1,"hello");

    int a;
    String b;

    Singleton(int a,String b) {
        this.a=a;
        this.b = b;
    }

    public void leaveTheBuilding(){
        System.out.println("bye");
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.leaveTheBuilding();
    }
}

