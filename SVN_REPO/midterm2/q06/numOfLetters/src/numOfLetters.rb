def count_letters(string, counts = Hash.new(0))
  return counts if string.empty?

  current_letter_count = counts.merge(string[0] => counts[string[0]] + 1)
  count_letters(string[1..-1], current_letter_count)
end

def print_letter_counts(letter_counts)
  letter_counts.each do |letter, count|
    puts "#{letter}: #{count} times"
  end
end

print "Enter the string: "
user_input = gets.chomp

letter_counts = count_letters(user_input)
print_letter_counts(letter_counts)


