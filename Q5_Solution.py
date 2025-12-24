"""
    Q5. What is the output?

    a = [1, 2, 3]
    b = a
    b.append(4)
    print(a)

    Why does this happen?

    How would you avoid this behavior?

"""

a = [1, 2, 3]

b = a

b.append(4)

print(a , " <-- a")

print(b , " <-- b")

# Output: 
#   [1, 2, 3, 4] <-- a
#   [1, 2, 3, 4] <-- b

# Why does this happen?
# Because b is a reference to the same list as a, so when we append 4 to b, it also adds 4 to a.

# How would you avoid this behavior?
# We can avoid this behavior by creating a new list and assigning it to b.

a = [1, 2, 3]

b = a[:] # cloning the list(deep copy)

b.append(4)

print(a , " <-- a")

print(b , " <-- b")

# Output: 
#   [1, 2, 3] <-- a
#   [1, 2, 3, 4] <-- b
