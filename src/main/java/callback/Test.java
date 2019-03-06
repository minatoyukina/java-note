package callback;

public class Test {

    public static void main(String[] args) {
        System.out.println("通知学生答题：777-111=？");
        CallbackTest test = new CallbackTest();
        test.handleThings(string -> System.out.println("答案是 " + string ));
//        test.handleThings(new Callback() {
//            @Override
//            public void sendMessage(String string) {
//                System.out.println("答案是 " + string);
//            }
//        });
        for (int i = 0; i < 20; i++) {
            System.out.println("等学生回答问题时老师玩了 " + i + " s手机");
        }
    }
}

@FunctionalInterface
interface Callback {
    void sendMessage(String string);
}




