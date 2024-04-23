
#include <array>
#include <vector>
using namespace std;

class Solution {

    static constexpr array<int, 2> RANGE_OF_VALUES = { 0, 100 };

public:
    vector<int> smallerNumbersThanCurrent(const vector<int>& input) const {
        array<int, RANGE_OF_VALUES[1] + 1> prefixSumFrequency{};
        for (int value : input) {
            ++prefixSumFrequency[value];
        }
        for (int i = 1; i < prefixSumFrequency.size(); ++i) {
            prefixSumFrequency[i] = prefixSumFrequency[i - 1] + prefixSumFrequency[i];
        }

        vector<int> smallerNumbersThanCurrent(input.size());
        for (int i = 0; i < input.size(); ++i) {
            smallerNumbersThanCurrent[i] = (input[i] > 0) ? prefixSumFrequency[input[i] - 1] : 0;
        }
        return smallerNumbersThanCurrent;
    }
};
