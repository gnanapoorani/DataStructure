class TurnOffRMSB {
    // Driver Code
    public static void main(String[] args)
    {
        int n = 7;
        System.out.print("The number after unsetting the rightmost set bit: " + fun(n));
    }
    // unsets the rightmost set bit
    // of n and returns the result
    static int fun(int n)
    {
        String bt2 = Integer.toBinaryString(n);
        bt2 = String.format("%32s", bt2).replace(' ', '0');
        System.out.println(bt2);

         bt2 = Integer.toBinaryString(-n);
        bt2 = String.format("%32s", bt2).replace(' ', '0');
        System.out.println(bt2);

        int k=(n & (-n));
         bt2 = Integer.toBinaryString(k);
        bt2 = String.format("%32s", bt2).replace(' ', '0');
        System.out.println(bt2);

        return n -k ;
    }



}