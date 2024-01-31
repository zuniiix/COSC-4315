def is_perfect_number_imperative(number):
    sum_of_factors = 0  
  
    for i in range(1, number + 1):
        sum_of_factors += i if number % i == 0 else 0

    return number > 1 and sum_of_factors == number * 2



def is_perfect_number_functional(number):
    return number > 1 and sum(factor for factor in range(1, number + 1) if number % factor == 0) == number * 2


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(index, path):
            res.append(path)
            for i in range(index, len(nums)):
                dfs(i + 1, path + [nums[i]])
        res = []
        dfs(0, [])
        return res