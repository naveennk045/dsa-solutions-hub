package solvedproblems.companywise.tcs;

public class WildcardMatching {
    public static boolean isMatch(char[] pattern,char[] text,int tInd,int pInd){
        while(pInd<pattern.length && tInd<text.length){
            System.out.println(pInd +"-- "+ tInd);

            if(pattern[pInd]==text[tInd] || pattern[pInd]=='?'){
                pInd++;
                tInd++;
            }
            else if(pattern[pInd]=='*'){
                tInd++;
                while(pInd<pattern.length &&pattern[pInd] != text[tInd] ) {
                    pInd++;
                }
                System.out.println(pInd +" "+ tInd);
            }
                else if(pattern[pInd]!=text[tInd])   return false;

        }
        return true;

    }
    public static void main(String[] args) {
        char[] pattern = {'a','b','c','*','f'};
        char[] text = {'a','b','c','d','e','f'};
        System.out.println(isMatch(pattern,text,0,0));
    }
}