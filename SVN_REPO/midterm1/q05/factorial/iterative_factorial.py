import math 

def iterative_factorial_series(number):
    return [math.prod(range(1, i + 1)) for i in range(1, number + 1)]


if __name__ == "__main__":
    sample_values = [1, 4, 7, 10]
    for number in sample_values:
        result = iterative_factorial_series(number)
        print(f"For n = {number}, the result is {result}")