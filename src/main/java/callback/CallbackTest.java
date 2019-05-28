package callback;

public class CallbackTest {
    static {
        System.out.println("hello");
        CallbackTest test=new CallbackTest();
    }
    public void handleThings(Callback callback) {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("思考中 " + i + " s");
            }
            callback.sendMessage("666");
        }).start();
//        for(int i=0;i<30;i++)
//            System.out.println("思考中 " + i + " s");
//        callback.sendMessage("666");

        System.out.println("收到题目");
    }
}
