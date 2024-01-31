import unittest
from src.repeated_letter import first_repeated_letter

class TestFirstLetter(unittest.TestCase):

    def test_first_repeated_letter(self):
        self.assertEqual(first_repeated_letter("hello there"), "h")
        self.assertEqual(first_repeated_letter("hello okay"), "l")
        self.assertEqual(first_repeated_letter("hello elmo"), "e")
        self.assertEqual(first_repeated_letter("hello"), "l")
        self.assertEqual(first_repeated_letter("hello sam"), "l")
        self.assertEqual(first_repeated_letter("gopher"), "o")
        self.assertEqual(first_repeated_letter("and this oy"), "o")
        self.assertEqual(first_repeated_letter(""), None)

if __name__ == "__main__":
    unittest.main()