package slidingwindow.level1;

public class MinimumWindow {
//    using sliding window
    public static String minWindowII(String s, String t) {
//        Case 1
        if (s.length() < t.length()) return "";


        int minLength = s.length() + 1;
        String result = "";
        int left=0;
        int right=t.length()-1;

        while(right<s.length()){
            String currWindow=s.substring(left,right+1);
            System.out.println(currWindow);
            if(isContains(currWindow,t)){
                int length=currWindow.length();
                if(minLength>length){
                    minLength=length;
                    result=currWindow;
                }
                left++;
            }else{
                right++;
            }
        }

        while(left<s.length()-t.length()) {
            String currWindow = s.substring(left, right);
            System.out.println(currWindow);
            if (isContains(currWindow, t)) {
                int length = currWindow.length();
                if (minLength > length) {
                    minLength = length;
                    result = currWindow;
                }
            }
            left++;
        }
        return result;
    }
    public static String minWindowI(String s, String t) {
        if(s.length()==t.length()){
            if(s.equals(t)) return s;
            else return "";
        }
        if(s.length()<t.length()) return "";
        int minLength=s.length()+1;
        String result="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String subString=s.substring(i,j+1);
                if(isContains(subString,t)){
                    int length=subString.length();
                    if(minLength>length){
                        minLength=length;
                        result=subString;
                    }
                }
//                System.out.println(subString);
            }
        }
        return result;
    }
    public static boolean isContains(String str1,String str2){
        int[] freq=new int[128];
        for (char ch : str1.toCharArray()){
            freq[ch]++;
        }
        for (char ch : str2.toCharArray()){
            if(freq[ch]<1){
                return false;
            }
            if(freq[ch]>=1)
                freq[ch]--;
        }
        return true;
    }
    public static void main(String[] args) {
        String  s = "ab", t = "A";
        System.out.println(minWindowI(s,t));
        System.out.println(minWindowII(s,t));
    }
}