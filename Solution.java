
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        if (nums[0] < 0 && nums[nums.length - 1] <= 0) {
            return new ArrayList<>();
        }
        if (nums[0] >= 0 && nums[nums.length - 1] > 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        int pointerOne = 0;

        while (pointerOne < size - 2) {

            int firstNum = nums[pointerOne];
            int pointerTwo = pointerOne + 1;
            int pointerThree = size - 1;

            while (pointerTwo < pointerThree) {

                int secondNum = nums[pointerTwo];
                int thirdNum = nums[pointerThree];

                if (firstNum + secondNum + thirdNum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(firstNum, nums[pointerTwo], nums[pointerThree])));

                    //skip duplicates.
                    while (pointerTwo < pointerThree && nums[pointerTwo] == secondNum) {
                        pointerTwo++;
                    }
                    //skip duplicates.
                    while (pointerTwo < pointerThree && nums[pointerThree] == thirdNum) {
                        pointerThree--;
                    }
                } else if (firstNum + secondNum + thirdNum < 0) {
                    pointerTwo++;
                } else {
                    pointerThree--;
                }
            }
          
            //skip duplicates.
            while (pointerOne < size - 2 && nums[pointerOne] == firstNum) {
                pointerOne++;
            }
        }
        return result;
    }
}
