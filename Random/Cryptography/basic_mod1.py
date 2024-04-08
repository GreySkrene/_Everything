# Define the character set
charset = 'abcdefghijklmnopqrstuvwxyz0123456789_'

def mod_inverse(a, m):
    for i in range(1, m):
        if (a * i) % m == 1:
            return i
    return None

# Numbers to decode
numbers = [104, 372, 110, 436, 262, 173, 354, 393, 351, 297, 241, 86, 262, 359, 256, 441, 124, 154, 165, 165, 219, 288, 42]
mod41_numbers = [num % 41 for num in numbers]
# print(mod41_numbers)
mod_inverse_numbers = [mod_inverse(num, 41) for num in mod41_numbers]
# mod_inverse_numbers = [28, 14, 22, 30, 18, 32, 30, 12, 25, 37, 8, 31, 18, 4, 37, 4, 1, 1, 3, 1, 1]

# Decode each number
decoded_chars = [charset[num % 37] for num in mod_inverse_numbers]

# Join the characters to form the decoded string
decoded_string = ''.join(decoded_chars)

print(decoded_string)
