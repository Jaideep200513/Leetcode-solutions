            result.add(new ArrayList<>(currList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            currList.add(nums[i]);
            backtrack(result, currList, nums, used);
            currList.remove(currList.size() - 1);
            used[i] = false;
        }
    }
}