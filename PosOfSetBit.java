
class RotateBits {
    public static void main(String[] args) {

        System.out.println(findPosition(0));
    }

    static int findPosition(int N) {
        int i = 1, count = 0, pos = 0;
        while (N > 0) {
            if ((N & i) != 0) {
                count++;
            }
            pos++;
            N = N >> 1;
        }
        if(count>1 || count==0){
            return -1;
        }
        return pos;
    }

}