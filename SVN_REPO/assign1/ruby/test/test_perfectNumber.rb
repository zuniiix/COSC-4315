require 'test/unit'
require_relative '../src/perfectNumber'

class TestPerfectNumber < Test::Unit::TestCase
  def test_perfect_number
    test_cases = [6, 28, 496, 8128]
    test_cases.each do |number|
      assert(is_perfect_number_imperative(number), "#{number} is a perfect number (imperative)")
      assert(is_perfect_number_functional(number), "#{number} is a perfect number (functional)")
    end
  end

  def test_non_perfect_number
    non_perfect_numbers = [78, 48, 1234, 8, 20, 9, 11]
    non_perfect_numbers.each do |number|
      assert(!is_perfect_number_imperative(number), "#{number} is NOT a perfect number (imperative)")
      assert(!is_perfect_number_functional(number), "#{number} is NOT a perfect number (functional)")
    end
  end

  def test_number_less_than_or_equal_to_1
    test_cases = [0, 1, -1, -100]
    test_cases.each do |number|
      assert(!is_perfect_number_imperative(number), "#{number} should return False (imperative)")
      assert(!is_perfect_number_functional(number), "#{number} should return False (functional)")
    end
  end
end
