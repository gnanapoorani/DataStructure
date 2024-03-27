class LeftShiftOperator {
    public static void main(String[] args)
    {
        int num1 = 1024;

        String bt1 = Integer.toBinaryString(num1);
        bt1 = String.format("%32s", bt1).replace(' ', '0');
        System.out.println(bt1);

        int num2 = num1 << 1;
        String bt2 = Integer.toBinaryString(num2);
        bt2 = String.format("%32s", bt2).replace(' ', '0');
        System.out.println(bt2);

        int num3 = num1 << 2;
        String bitset13 = Integer.toBinaryString(num3);
        bitset13 = String.format("%16s", bitset13)
                .replace(' ', '0');
        System.out.println(bitset13);
        System.out.println(num3);

        int num4 = num1 << 10;
        String bitset14 = Integer.toBinaryString(num4);
        bitset14 = String.format("%32s", bitset14)
                .replace(' ', '0');
        System.out.println(bitset14);
        System.out.println(num4);
    }
}