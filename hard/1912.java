/*
1912. Design Movie Rental System 

Approach :
We need to support 4 operations efficiently:
    1. Search(movie): return cheapest 5 shops with unrented copy.
    2. Rent(shop, movie): mark as rented.
    3. Drop(shop, movie): return rented movie.
    4. Report(): return cheapest 5 rented movies.

Data Structures
  1. priceMap → Map<Pair<shop, movie>, price>  (to quickly lookup the price of a movie in a shop).
  2. available[movie] → TreeSet<[price, shop]>  (all shops where this movie is unrented, sorted by price then shop).
  3.  rented → TreeSet<[price, shop, movie]>  (all rented movies globally, sorted by price → shop → movie).

Both use TreeSet (balanced BST) so we can efficiently insert, remove, and fetch smallest elements.
*/

import java.util.*;

class MovieRentingSystem {
    private Map<Integer, TreeSet<int[]>> available; // movie -> shops with unrented copy
    private TreeSet<int[]> rented;                  // all rented movies
    private Map<String, Integer> priceMap;          // (shop,movie) -> price

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // price
            if (a[1] != b[1]) return a[1] - b[1]; // shop
            return a[2] - b[2];                   // movie
        });
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // price
                return a[1] - b[1];                   // shop
            }));
            available.get(movie).add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        Iterator<int[]> it = available.get(movie).iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            res.add(it.next()[1]); // shop
            cnt++;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            int[] cur = it.next();
            res.add(Arrays.asList(cur[1], cur[2])); // [shop, movie]
            cnt++;
        }
        return res;
    }
}
