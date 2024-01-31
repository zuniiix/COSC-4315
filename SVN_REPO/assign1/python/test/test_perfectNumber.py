import unittest
from src.perfectNumber import is_perfect_number_imperative, is_perfect_number_functional

class TestPerfectNumber(unittest.TestCase):

    def test_perfect_number(self):
        test_cases = [6, 28, 496, 8128]
        for number in test_cases:
            with self.subTest(number=number):
                self.assertTrue(is_perfect_number_imperative(number), f"{number} is a perfect number (imperative)")
                self.assertTrue(is_perfect_number_functional(number), f"{number} is a perfect number (functional)")

    def test_non_perfect_number(self):
        non_perfect_numbers = [78, 48, 1234, 8, 20, 9, 11]
        for number in non_perfect_numbers:
            with self.subTest(number=number):
                self.assertFalse(is_perfect_number_imperative(number), f"{number} is NOT a perfect number (imperative)")
                self.assertFalse(is_perfect_number_functional(number), f"{number} is NOT a perfect number (functional)")

    def test_number_less_than_or_equal_to_1(self):
        test_cases = [0, 1, -1, -100]
        for number in test_cases:
            with self.subTest(number=number):
                self.assertFalse(is_perfect_number_imperative(number), f"{number} should return False (imperative)")
                self.assertFalse(is_perfect_number_functional(number), f"{number} should return False (functional)")

if __name__ == '__main__':
    unittest.main()
