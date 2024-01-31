def recursive_factorial(number):
    if number == 1:
        return [1]
    else:
        prev_results = recursive_factorial(number - 1)
        return prev_results + [number * prev_results[-1]]

if __name__ == "__main":
  sample_values = [1, 4, 7, 10]

  for number in sample_values:
    result = recursive_factorial(number)
    print(f"factorials of n = {number}: {result}")