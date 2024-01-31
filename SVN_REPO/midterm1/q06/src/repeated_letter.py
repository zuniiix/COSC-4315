def first_repeated_letter(input_string):
    seen = set()
    for char in input_string:
        if char != ' ' and char in seen:
            return char
        seen.add(char)
    return ""



