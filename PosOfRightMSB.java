class PosOfRightMSB {
    public static void main(String[] args)
    {
        int n = 18;
        System.out.println(getFirstSetBitPos(n));
    }
    public static int getFirstSetBitPos(int n)
    {
        int k= n & -n;
        return (int)((Math.log10(k)) / Math.log10(2))
                + 1;
    }
}