list1=[10,12,15,99,67,34]
list2=[32,15,67,31,76,44,88]
result_list=[]
for num in list1:
    if (num % 2 != 0):
        result_list.append(num)
# Iterate through first list to get even elements
for num in list2:
    if (num % 2 == 0):
        result_list.append(num)
 
# Print result
print("result List is:")
print(result_list)
