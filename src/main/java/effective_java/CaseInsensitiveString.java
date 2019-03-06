package effective_java;

import java.util.ArrayList;
import java.util.List;

public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj instanceof CaseInsensitiveString)
//            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//        if (obj instanceof String)
//            return s.equalsIgnoreCase((String) obj);
//        return false;

        return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString string = new CaseInsensitiveString("Java");
        System.out.println(string.equals("java"));
        System.out.println("java".equals(string));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(string);
        System.out.println(list.contains("java"));
    }
}
