/*
2353. Design a Food Rating System

Approach:
1. Use two HashMaps:
    foodToRating → stores food → rating
    foodToCuisine → stores food → cuisine
2.Store all foods in an array for iteration.
3. For changeRating: just update the rating in foodToRating.
4. For highestRated:
    Loop through all foods.
    Pick the one with highest rating (tie → lexicographically smallest).
*/

import java.util.*;

public class FoodRatings {
    private static class Node {
        String name;
        int rating;
        Node(String n, int r) { name = n; rating = r; }
    }

    private final Map<String, Integer> ratingMap;       // food -> rating
    private final Map<String, String> cuisineMap;       // food -> cuisine
    private final Map<String, PriorityQueue<Node>> pqMap; // cuisine -> max-heap of Node (lazy deletions)

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        ratingMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        pqMap = new HashMap<>();

        Comparator<Node> comp = (a, b) -> {
            if (a.rating != b.rating) return Integer.compare(b.rating, a.rating); // higher rating first
            return a.name.compareTo(b.name); // lexicographically smaller first
        };

        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];

            ratingMap.put(f, r);
            cuisineMap.put(f, c);
            pqMap.computeIfAbsent(c, k -> new PriorityQueue<>(comp)).offer(new Node(f, r));
        }
    }

    public void changeRating(String food, int newRating) {
        ratingMap.put(food, newRating);
        String cuisine = cuisineMap.get(food);
        // Push new node; old entry remains and will be lazily discarded when popped
        pqMap.get(cuisine).offer(new Node(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Node> pq = pqMap.get(cuisine);
        // Lazily remove outdated entries
        while (!pq.isEmpty()) {
            Node top = pq.peek();
            int currentRating = ratingMap.get(top.name);
            if (top.rating == currentRating) return top.name;
            pq.poll();
        }
        return ""; // per constraints this shouldn't happen
    }
}
