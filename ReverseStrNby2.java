public class ReverseStrNby2 {
    public static void main(String[] args) {
        String s="Hello";
        System.out.println("Reverse string " + reverseStr(s));   
    }   

    public static String reverseStr(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int j = len-1;
        for(int i=0; i < len/2; i++, j--) {
            char t = chars[i];
            chars[i]=chars[j];
            chars[j] = t;
        }
        return new String(chars);
    }
}
