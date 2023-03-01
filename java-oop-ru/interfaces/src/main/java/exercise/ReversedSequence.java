package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private String s;

    public ReversedSequence(String s) {
        this.s = s;
    }

    @Override
    public int length() {
        return this.s.length();
    }

    @Override
    public char charAt(int i) {
        return this.s.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return this.s.substring(i, i1);
    }

    public static String toString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
// END
