import unittest
from src.sample import *

class SampleTest(unittest.TestCase):

  def test_canary(self):
    self.assertTrue(True)

  def test_add(self):
    self.assertEqual(3, add(1, 2))

if __name__ == '__main__':
	unittest.main()
