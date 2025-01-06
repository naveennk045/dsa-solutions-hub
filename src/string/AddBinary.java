package string;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int n1=a.length()-1;
        int n2=b.length()-1;
        int maxLength=Math.max(n1,n2);
        StringBuilder sb=new StringBuilder();
        int carry=0;
        while(maxLength>=0){
            int digit1=(n1<0)?0:a.charAt(n1)-'0';
            int digit2=(n2<0)?0:b.charAt(n2)-'0';
            int sum=digit1+digit2+carry;
            int sum1=digit1|digit2|carry;
            sb.append(sum1);
            if(sum>1){
                carry=1;
            }
            else {
                carry=0;
            }


            n1--;
            n2--;
            maxLength--;


        }
        if(carry>0){
            sb.append(carry);
        }
        sb=sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1111","1111"));
    }
}