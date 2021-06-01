def calculate_sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum

numList = [10, 40, 60, 90]
result = calculate_sum(numList)

print("Sum of list elements: ", + result)