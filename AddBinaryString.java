class LeftShiftOperator {
    public static void main(String[] args) {
        String A = "00101";
        String B = "0";
        System.out.println(addBinary(A, B));
    }

    static String addBinary(String A, String B) {
        StringBuilder result=new StringBuilder();
        int i=A.length()-1,j=B.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry>0){
            if(i>=0){
                carry=A.charAt(i)-'0';
            }
            if(j>=0){
                carry=B.charAt(j)-'0';
            }

            result.append(carry%2);
            carry=carry/2;
            i--;
            j--;
        }
        return result.reverse().toString();

    }

}