import java.util.*;

class Solution {
    public int minGroupsForValidAssignment(int[] balls) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int ball : balls) {
            counts.put(ball, counts.getOrDefault(ball, 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;
        for (int freq : counts.values()) {
            minFreq = Math.min(minFreq, freq);
        }

        for (int size = minFreq; size >= 1; size--) {
            int totalGroups = 0;
            boolean valid = true;

            for (int freq : counts.values()) {
                int groups = freq / (size + 1);
                int remainder = freq % (size + 1);

                if (remainder == 0) {
                    totalGroups += groups;
                } else {
                    int neededSlots = size - remainder;
                    if (groups >= neededSlots) {
                        totalGroups += groups + 1;
                    } else {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                return totalGroups;
            }
        }

        return balls.length;
    }
}