public class SubstrSearch {
    // returns starting index of s2 in s1 else -1
    public static int hasSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        for(int i=0; i<= m-n; i++) {
            int j;
            for(j=0; j<n; j++) {
                if(s1.charAt(i+j) != s2.charAt(j)) {
                    break;
                }
            }
            if(j == n) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var s1 = "geeksforgeeks";
        var s2 = "for";
        assert hasSubstring(s1,s2) != -1 : (s1 + " contains " + s2);
        assert hasSubstring(s1,s2) == 5 : (s1.indexOf(s2));
        s2 = "Geeks";
        assert hasSubstring(s1,s2) != -1 : (s1 + " does not contain " + s2);
    }
}
