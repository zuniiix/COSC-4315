def TCO_factorial(number, current=1, result=1):
    if current > number:
        return []
    else:
        result *= current
        return [result] + TCO_factorial(number, current + 1, result)

if __name__ == "__main__":
  sample_values = [1, 4, 7, 10]
  for number in sample_values:
    result = TCO_factorial(number)
    print(f"For n = {number}, the result is {result}")