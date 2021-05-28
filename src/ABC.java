import java.util.HashMap;

public class ABC {


    public static int removeDuplicates(final int[] nums) {
        int readIndex = 0, writeIndex = 0;
        int temp;
        //final int maxNumberOfDuplicates = 2;
        while (readIndex < nums.length) {
            final int currentElement = nums[readIndex];
                int numberOfOccurenceOfCurrentElement = 0;
                while (readIndex < nums.length && nums[readIndex] == currentElement) {
                    numberOfOccurenceOfCurrentElement++;
                    if (numberOfOccurenceOfCurrentElement <= 2) {
                        temp = nums[readIndex];
                        nums[readIndex] = nums[writeIndex];
                        nums[writeIndex] = temp;
                        writeIndex++;
                    }
                    readIndex++;
                }
        }

        return writeIndex;
    }



    public static void main(String[] args) {
        HashMap<String, Boolean> hm = new HashMap<>();
        hm.put(null, true);
        hm.put(null, true);
        System.out.println(hm);
        int nums[] = {-2147483648,-2147483648,-2147483648,1,1,1,2};
        printAnswer(nums);
        int nums1[] = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        printAnswer(nums1);


    }

    private static void printAnswer(final int[] nums) {
        final int answer = removeDuplicates(nums);
        System.out.println(answer);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


}
