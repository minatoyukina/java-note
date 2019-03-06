package crawler.yandere;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    private void get_images(String filePath, String imgUrl) throws Exception {
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = imgUrl.split("%")[1] + ".png";
        File file = new File(filePath + File.separator + fileName);
        URL url = new URL(imgUrl);
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(10 * 1000);
        InputStream in = connection.getInputStream();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buf = new byte[1024];
        int size;
        while ((size = in.read(buf)) != -1) {
            out.write(buf, 0, size);
        }
        out.close();
        in.close();
    }

    public void run() {
        while (true) {
            try {
                String url = queue.take();
                get_images("C:\\Users\\chenchuanqi\\下载\\imgs1", url);
                System.out.println(url.split("%")[1] + " 下载完成 " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (queue.isEmpty()) break;
        }

    }
}
