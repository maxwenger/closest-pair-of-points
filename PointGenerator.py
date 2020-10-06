#!/usr/bin/python3
import sys
import random

numberOfPoints  = int(sys.argv[1])
lowerBound  = int(sys.argv[2])
upperBound  = int(sys.argv[3])

for n in range(numberOfPoints):
    x = str(random.randint(lowerBound, upperBound))
    y = str(random.randint(lowerBound, upperBound))
    print(x + " " + y)
