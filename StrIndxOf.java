public class StrIndxOf {
    public static void main(String[] args) {
        String strOrg = "Hello world,Hello Reader!";
        String subStr = "Hello";

        System.out.println("Last index of substring: " + lastIndexOf(strOrg,subStr));
        //System.out.println("Last index of substring: " + strOrg.lastIndexOf(subStr));
    }

    public static int lastIndexOf(String orgStr, String subStr) {
        int lastIdx=-1;
        for(int i=0; i<orgStr.length(); i++) {
            boolean f=false;
            for(int j=0;j<subStr.length() && (i+j)<orgStr.length();j++) {
                if(subStr.charAt(j) == orgStr.charAt(i)) {
                    f=true;
                    if(subStr.charAt(j) != orgStr.charAt(i+j)) {
                        f=false;
                        break;
                    }
                }
            }
            if(f==true) {
                lastIdx=i;
            }
        }
        return lastIdx;
    }
}
