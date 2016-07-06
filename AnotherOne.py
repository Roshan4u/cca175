import sys

from pyspark import SparkContext, SparkConf

if __name__ == "__main__":
    print("we are finally set up")
    print("do you wanna know my argv?")

    i = 0

    while i < len(sys.argv):
        print(sys.argv[i])
        i = i + 1

    print("is this what you are looking for?")