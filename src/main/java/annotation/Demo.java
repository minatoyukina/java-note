package annotation;

public class Demo {

    @Before
    @After(name = "47")
    public void demo(){
        for (int i = 0; i < 10; i++) {
            System.out.println("--------"+i+"----------");
        }
    }
}
