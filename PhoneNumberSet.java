import java.util.ArrayList;

class PowerImpl {
    public static void main(String[] args) {

        System.out.println(phoneNumber("", "12"));
    }

    public static ArrayList<String> phoneNumber(String Processed, String S) {
        ArrayList<String> answer = new ArrayList<>();
        if (S.isEmpty()) {
          answer.add(Processed);
            return answer;
        }
        int digit = S.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch=(char)('a'+i);
           answer.addAll(phoneNumber(Processed + ch, S.substring(1)));
        }
        return  answer;
    }

}