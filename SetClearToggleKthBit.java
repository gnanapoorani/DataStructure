class SetClearToggleKthBit {
    public static void main(String arg[])
    {
        int n = 10, k = 2;
        System.out.println("Kth bit set number = " +
                setKthBit(n, k));

        int n1 = 5, k1 = 1;

        System.out.println(clearBit(n1, k1));

        int n2 = 5, k2 = 2;

        System.out.printf("%d\n", toggleBit(n2, k1));
        int num = 31;
        System.out.println(countSetBitsRec(num));

        countSetBits(15);
    }


    // function to set the kth bit
    static int setKthBit(int n, int k)
    {
        // kth bit of n is being set by this operation
        return ((1 << k) | n);
    }

    static int clearBit(int n, int k)
    {
        return (n & (~(1 << k)));
    }

    // Function to toggle the kth bit of n
    static int toggleBit(int n, int k)
    {
        return (n ^ (1 << k));
    }

    /* Recursively get nibble of a given number
and map them in the array */
    static int countSetBitsRec(int num)
    {
         int[] num_to_bits = new int[] { 0, 1, 1, 2, 1, 2, 2,
                3, 1, 2, 2, 3, 2, 3, 3, 4 };
        int nibble = 0;
        if (0 == num)
            return num_to_bits[0];

        // Find last nibble
        nibble = num & 0xf;

        // Use pre-stored values to find count
        // in last nibble plus recursively add
        // remaining nibbles.
        return num_to_bits[nibble] + countSetBitsRec(num >> 4);
    }

    // Function to find largest power of 2 such that
    // pow(2,k) <= N
    static int findk(int n)
    {
        int k = 0;
        int i = 0;
        int val = (int)Math.pow(2, i);

        while (val <= n) {
            k = i;
            i++;
            val = (int)Math.pow(2, i);
        }
        return k;
    }

    // Function to count set bits in a number
    static int countSetBits(int N)
    {
        int count = 0;
        int k = findk(N);
        int val, x;

        // Iterating from largest power to 2 such that
        // pow(2,k) to 0
        for (int i = k; i >= 0; i--) {
            val = (int)Math.pow(2, i);
            x = val
                    & N; // x will store Bitwise AND of N & val

            if (x > 0) {
                count++;
            }
        }
        return count; // return count of set bits
    }

    // Check each bit in a number is set or not
    // and return the total count of the set bits.
    static int countSetBits2(int N)
    {
        int count = 0;
        // (1 << i) = pow(2, i)
        for (int i = 0; i < 4 * 8; i++)
        {
            if ((N & (1 << i)) != 0)
                count++;
        }
        return count;
    }


}