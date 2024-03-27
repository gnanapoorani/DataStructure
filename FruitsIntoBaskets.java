import java.util.HashMap;

class FruitsIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int left = 0, max = 1;
        HashMap<Integer,Integer> basket = new HashMap<>();
        basket.put(fruits[left],1);
        for (int right = 1; right < fruits.length; right++) {
          if(basket.containsKey(fruits[right])){
              basket.replace(fruits[right],basket.get(fruits[right])+1);
          }else if(basket.size()<2){
              basket.put(fruits[right],1);
          }else{
              if (basket.get(fruits[left])<=1) {
                  basket.remove(fruits[left]);
                  basket.put(fruits[right],1);
              }else{
                  basket.replace(fruits[left],basket.get(fruits[left])-1);
                  right--;
              }
              left++;
          }
          max=Math.max(max,(right-left)+1);
        }
        return max;
    }
}