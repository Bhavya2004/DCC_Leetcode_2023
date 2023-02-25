class Solution:
    def maxProfit(self, prices: List[int]) -> int: 
        if not prices:
            return 0
        min_price = prices[0]
        max_profit = 0
        for price in prices:
            if price < min_price:
                min_price = price
            else:
                profit = price - min_price
                if profit > max_profit:
                    max_profit = profit
        return max_profit
# we first check if the prices array is empty and return 0 if it is. Otherwise, 
# we initialize the minimum price seen so far to be the first price in the array and the maximum profit to be 0.
#  We then loop through the prices array and update the minimum price and maximum profit as described above.