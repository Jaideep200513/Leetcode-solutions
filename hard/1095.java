 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex = findPeak(mountainArr, length);
        int result = findTarget(mountainArr, 0, peakIndex, target, true);
        if (result != -1) {
            return result;
        }
        return findTarget(mountainArr, peakIndex + 1, length - 1, target, false);
    }
    private int findTarget(MountainArray mountainArr, int left, int right, int target, boolean isUpside) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {