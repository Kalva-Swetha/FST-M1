num=int(input("Enter size of list: "))
list=[]
i=0
for i in range(num):
    a=int(input("Enter number: "))
    list.append(a)
    i=i+1
print('User input list ',list)
sum=0
for i in range(num):
    sum=sum+list[i]
    i=i+1
print('Sum of list elements is: ',sum)