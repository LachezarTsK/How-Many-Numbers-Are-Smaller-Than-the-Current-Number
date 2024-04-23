
function smallerNumbersThanCurrent(input: number[]): number[] {
    const RANGE_OF_VALUES = [0, 100];
    const prefixSumFrequency = new Array(RANGE_OF_VALUES[1] + 1).fill(0);
    for (let value of input) {
        ++prefixSumFrequency[value];
    }
    for (let i = 1; i < prefixSumFrequency.length; ++i) {
        prefixSumFrequency[i] = prefixSumFrequency[i - 1] + prefixSumFrequency[i];
    }

    const smallerNumbersThanCurrent: number[] = new Array(input.length);
    for (let i = 0; i < input.length; ++i) {
        smallerNumbersThanCurrent[i] = (input[i] > 0) ? prefixSumFrequency[input[i] - 1] : 0;
    }
    return smallerNumbersThanCurrent;
};
