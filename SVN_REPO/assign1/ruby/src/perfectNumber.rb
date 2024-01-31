def is_perfect_number_imperative(number)
  sum_of_factors = 0

  for i in 1..number
    sum_of_factors += i if (number % i).zero?
  end

  number > 1 && sum_of_factors == number * 2
end


def is_perfect_number_functional(number)
  (1..number).select { |factor| (number % factor).zero? }.sum == number * 2 && number > 1
end
