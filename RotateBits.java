import java.util.ArrayList;

class RotateBits {
    public static void main(String[] args) {

        System.out.println(leftRotate(10, 8));
        System.out.println(rightRotate(10, 8));
    }



    /*Function to left rotate n by d bits*/
    static int leftRotate(int n, int d) {
         final int INT_BITS = 16;

    /* In n<<d, last d bits are 0.
       To put first 3 bits of n at
       last, do bitwise or of n<<d with
       n >>(INT_BITS - d) */
        return (n << d) | (n >> (INT_BITS - d));
    }

    /*Function to right rotate n by d bits*/
    static int rightRotate(int n, int d) {

         final int INT_BITS = 16;

    /* In n>>d, first d bits are 0.
       To put last 3 bits of at
       first, do bitwise or of n>>d
       with n <<(INT_BITS - d) */
        return (n >> d) | (n << (INT_BITS - d));
    }

    static int findSingle(int N, int arr[]){
        int xor=0;
      for(int i=0;i<N;i++){
          xor=xor^arr[i];
      }
      return xor;
    }

}