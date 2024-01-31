def get_factors(num)
  (1..num).select { |x| (num % x).zero? }
end

def get_factors_for_list(passed_list)
  passed_list.map { |num| get_factors(num) }.flatten.uniq
end

input_list1 = [2, 5, 7, 8, 12, 18, 15].freeze
input_list2 = [2, 6].freeze

puts "#{input_list1}: #{get_factors_for_list(input_list1)}"
puts "#{input_list2}: #{get_factors_for_list(input_list2)}"

