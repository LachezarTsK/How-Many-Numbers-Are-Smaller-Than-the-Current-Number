
public class Solution {

    private static final int[] RANGE_OF_VALUES = {0, 100};

    public int[] smallerNumbersThanCurrent(int[] input) {
        int[] prefixSumFrequency = new int[RANGE_OF_VALUES[1] + 1];
        for (int value : input) {
            ++prefixSumFrequency[value];
        }
        for (int i = 1; i < prefixSumFrequency.length; ++i) {
            prefixSumFrequency[i] = prefixSumFrequency[i - 1] + prefixSumFrequency[i];
        }

        int[] smallerNumbersThanCurrent = new int[input.length];
        for (int i = 0; i < input.length; ++i) {
            smallerNumbersThanCurrent[i] = (input[i] > 0) ? prefixSumFrequency[input[i] - 1] : 0;
        }
        return smallerNumbersThanCurrent;
    }
}
