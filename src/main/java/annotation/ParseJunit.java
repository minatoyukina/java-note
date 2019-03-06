package annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseJunit {
    public void parseMethod(Class clazz) throws Exception {
        Object obj = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();

        int index = 0;
        Method methodBefore = null;
        Method[] methodsTest = null;
        Method methodAfter = null;

        for (Method method : methods) {
            Annotation[] myJunitTest = method.getAnnotations();
            for (int i = 0; i < myJunitTest.length; i++) {
                if (myJunitTest[0].annotationType().getSimpleName().endsWith("Before")) {
                    methodBefore = method;
                } else if (myJunitTest[0].annotationType().getSimpleName().endsWith("Test")) {
                    if (methodsTest == null) {
                        methodsTest = new Method[methods.length];
                    }
                    methodsTest[index] = method;
                    index++;
                } else if (myJunitTest[0].annotationType().getSimpleName().endsWith("After")) {
                    methodAfter = method;
                }
            }
        }

        if (methodBefore != null){
            System.out.println("before :在所有测试方法执行前执行这个方法");
            methodBefore.invoke(obj);
        }
        if (methodsTest != null) {
            for (Method method : methodsTest) {
                if (method != null)
                    method.invoke(obj);
            }
        }
        if (methodAfter != null) {
            methodAfter.invoke(obj);
            String string = methodAfter.getAnnotation(After.class).name();
            System.out.println("hello "+string);
            System.out.println("after :在所有测试方法执行后执行这个方法");
        }
    }

    @Test
    public void testApp() throws Exception {
        ParseJunit parseJunit = new ParseJunit();
        parseJunit.parseMethod(Demo.class);
    }


}
