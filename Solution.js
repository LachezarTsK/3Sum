
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
    if (nums.length < 3) {
        return [];
    }

    nums.sort((x, y) => x - y);
    if (nums[0] < 0 && nums[nums.length - 1] <= 0) {
        return [];
    }
    if (nums[0] >= 0 && nums[nums.length - 1] > 0) {
        return [];
    }

    const result = [];
    let size = nums.length;
    let pointerOne = 0;

    while (pointerOne < size - 2) {

        let firstNum = nums[pointerOne];
        let pointerTwo = pointerOne + 1;
        let pointerThree = size - 1;

        while (pointerTwo < pointerThree) {

            let secondNum = nums[pointerTwo];
            let thirdNum = nums[pointerThree];

            if (firstNum + secondNum + thirdNum === 0) {
                result.push([firstNum, nums[pointerTwo], nums[pointerThree]]);

                //skip duplicates.
                while (pointerTwo < pointerThree && nums[pointerTwo] === secondNum) {
                    pointerTwo++;
                }
                //skip duplicates.
                while (pointerTwo < pointerThree && nums[pointerThree] === thirdNum) {
                    pointerThree--;
                }
            } else if (firstNum + secondNum + thirdNum < 0) {
                pointerTwo++;
            } else {
                pointerThree--;
            }
        }

        //skip duplicates.
        while (pointerOne < size - 2 && nums[pointerOne] === firstNum) {
            pointerOne++;
        }
    }

    return result;
};
