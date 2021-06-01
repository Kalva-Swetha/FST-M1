import pytest
# Additon test
def test_addition():

	num1 = 100
	num2 = 15
	sum = num1 + num2
	assert sum == 250

# Subtraction test
def test_subtraction():
 
	num1 = 50
	num2 = 350

	diff = num1 - num2

	assert diff == 15

# Multiplication test
def test_multiplication():
 
	num1 = 50
	num2 = 20

	prod = num1 * num2

	assert prod == 1000

# Division test
def test_division():

	num1 = 100
	num2 = 5

	quot = num1 / num2

	assert quot == 20