import sys

from pyspark import SparkConf, SparkContext

conf = (SparkConf()
    .setMaster("local")
    .setAppName("The App")
    .set("spark.executor.memory", "1g")
    .set("spark.cores.max","4"))

sc = SparkContext(conf=conf)

def main():
    global conf, sc
    print("What are my job parameters?")

    for i in conf.getAll():
        print("{}\t\t\t\t\t:\t{}".format(i[0], i[1]))
    print("to prove you can access SparkContext")
    print(sc)
    print()
    print("*** WE DONE ***")

if __name__ == "__main__":
    main()