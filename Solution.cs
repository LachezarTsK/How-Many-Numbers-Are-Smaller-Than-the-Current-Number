
using System;

public class Solution
{
    private static readonly int[] RANGE_OF_VALUES = { 0, 100 };

    public int[] SmallerNumbersThanCurrent(int[] input)
    {
        int[] prefixSumFrequency = new int[RANGE_OF_VALUES[1] + 1];
        foreach (int value in input)
        {
            ++prefixSumFrequency[value];
        }
        for (int i = 1; i < prefixSumFrequency.Length; ++i)
        {
            prefixSumFrequency[i] = prefixSumFrequency[i - 1] + prefixSumFrequency[i];
        }

        int[] smallerNumbersThanCurrent = new int[input.Length];
        for (int i = 0; i < input.Length; ++i)
        {
            smallerNumbersThanCurrent[i] = (input[i] > 0) ? prefixSumFrequency[input[i] - 1] : 0;
        }
        return smallerNumbersThanCurrent;
    }
}
