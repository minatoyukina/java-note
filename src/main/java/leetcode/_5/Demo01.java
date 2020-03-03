package leetcode._5;

import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(longestPalindrome("rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlm" +
                "wnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtu" +
                "wvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsf" +
                "gjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqio" +
                "zworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmc" +
                "vtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycd" +
                "cscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoa" +
                "nhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbg" +
                "qtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngs" +
                "emcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip"));
        System.out.println(longestPalindrome("abc"));
    }

    private String longestPalindrome(String s) {
        String str = "";
        for (int i = 0; i <= s.length(); i++) {
            for (int j = s.length(); j >= i + 1; j--) {
                String substring = s.substring(i, j);
                if (substring.equals(new StringBuilder(substring).reverse().toString())) {
                    if (substring.length() > str.length()) {
                        str = substring;
                        break;
                    }
                }
            }
        }
        return str;
    }

}
