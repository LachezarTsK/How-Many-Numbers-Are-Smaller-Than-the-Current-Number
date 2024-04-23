
class Solution {

    companion object {
        val RANGE_OF_VALUES = intArrayOf(0, 100);
    }

    fun smallerNumbersThanCurrent(input: IntArray): IntArray {
        val prefixSumFrequency = IntArray(RANGE_OF_VALUES[1] + 1);
        for (value in input) {
            ++prefixSumFrequency[value];
        }
        for (i in 1..<prefixSumFrequency.size) {
            prefixSumFrequency[i] = prefixSumFrequency[i - 1] + prefixSumFrequency[i];
        }

        val smallerNumbersThanCurrent = IntArray(input.size);
        for (i in input.indices) {
            smallerNumbersThanCurrent[i] = if (input[i] > 0) prefixSumFrequency[input[i] - 1] else 0;
        }
        return smallerNumbersThanCurrent;
    }
}
