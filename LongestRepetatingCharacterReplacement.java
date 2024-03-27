import java.util.HashMap;
import java.util.Map;

/**
 * length of the entire string - number of times of the maximum occurring character in the string
 *
 * Given this, we can apply the at most k changes constraint and maintain a sliding window such that
 *
 * (length of substring - number of times of the maximum occurring character in the substring) <= k
 *
 */
class LongestRepetatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AAAA", 0));
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> bucket = new HashMap<>();
        int start = 0, end = 0, maxCharCount = 0, result = 0;
        for (end = 0; end < s.length(); end++) {
            char value = s.charAt(end);
            bucket.put(value, bucket.getOrDefault(value, 0) + 1);
            maxCharCount = Math.max(maxCharCount, bucket.get(value));
            while (end - start - maxCharCount + 1 > k) {
                bucket.replace(s.charAt(start), bucket.get(s.charAt(start)) - 1);
                start++;
                int recent = 0;
                for (Map.Entry<Character, Integer> entry : bucket.entrySet()) {
                    recent = Math.max(recent, entry.getValue());
                }
                maxCharCount = recent;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }

}