from typing import List
import heapq

class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.food_info = {}  # Maps food name to (cuisine, rating)
        self.cuisine_heaps = {}  # Maps cuisine to heap of (-rating, food) tuples
        
        for i in range(len(foods)):
            food = foods[i]
            cuisine = cuisines[i]
            rating = ratings[i]
            
            self.food_info[food] = (cuisine, rating)

            if cuisine not in self.cuisine_heaps:
                self.cuisine_heaps[cuisine] = []
            # Use negative rating for max heap (Python has min heap by default)
            heapq.heappush(self.cuisine_heaps[cuisine], (-rating, food))

    def changeRating(self, food: str, newRating: int) -> None:
        cuisine, _ = self.food_info[food]
        self.food_info[food] = (cuisine, newRating)
        # Add new entry to heap (we'll handle outdated entries during highestRated)
        heapq.heappush(self.cuisine_heaps[cuisine], (-newRating, food))

    def highestRated(self, cuisine: str) -> str:
        heap = self.cuisine_heaps[cuisine]
        
        # Keep popping until we find a valid entry
        while heap:
            neg_rating, food = heap[0]  # Peek at top of heap
            stored_cuisine, stored_rating = self.food_info[food]
            
            # If this entry is outdated (rating changed), remove it
            # The stored_rating is up to date.
            if -neg_rating != stored_rating:
                heapq.heappop(heap)  # Remove outdated entry
                continue
                
            # Found highest rated food with current ratings
            return food
        
# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)