import java.util.*;

class FoodRatings {
    HashMap<String, Integer> foodRatings;
    HashMap<String, String> foodCuisines;
    HashMap<String, TreeMap<Integer, TreeSet<String>>> cuisineFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatings = new HashMap<>();
        foodCuisines = new HashMap<>();
        cuisineFoods = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            foodRatings.put(foods[i], ratings[i]);
            foodCuisines.put(foods[i], cuisines[i]);
            cuisineFoods.putIfAbsent(cuisines[i], new TreeMap<>());
            cuisineFoods.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());
            cuisineFoods.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        if (foodRatings.containsKey(food)) {
            int oldRating = foodRatings.get(food);
            String cuisine = foodCuisines.get(food);
            cuisineFoods.get(cuisine).get(oldRating).remove(food);
            if (cuisineFoods.get(cuisine).get(oldRating).isEmpty()) {
                cuisineFoods.get(cuisine).remove(oldRating);
            }
            foodRatings.put(food, newRating);
            cuisineFoods.get(cuisine).putIfAbsent(newRating, new TreeSet<>());
            cuisineFoods.get(cuisine).get(newRating).add(food);
        }
    }
    
    public String highestRated(String cuisine) {
        if (!cuisineFoods.containsKey(cuisine) || cuisineFoods.get(cuisine).isEmpty()) {
            return null;
        }
        int highestRating = cuisineFoods.get(cuisine).lastKey();
        return cuisineFoods.get(cuisine).get(highestRating).first();
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */