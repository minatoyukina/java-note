package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    private static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        for (; ; )
            list.add(new OOMObject());
    }
}
