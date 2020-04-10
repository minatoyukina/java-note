package annotation;

public class MyJunitTest {
    @Before
    public void prepare(){
        System.out.println("before :在所有测试方法执行前执行这个方法");
    }

    @After(name = "hello")
    public void destroy(){
        System.out.println("after :在所有测试方法执行后执行这个方法");
    }

    @Test
    public void testUpdate(){
        System.out.println("test :testUpdate()");
    }
    @Test
    public void testAdd(){
        System.out.println("test :testAdd()");
    }
}
