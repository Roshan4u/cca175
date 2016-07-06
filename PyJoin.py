import sys

from pyspark import SparkContext, SparkConf

if __name__ == "__main__":
    # create sprakContext and its configuration
    conf = SparkConf().setAppName("Pie Join")
    sc = SparkContext(conf=conf)

    # we wanna our first file
    first = sc.textFile(sys.argv[1])

    # then second
    second = sc.textFile(sys.argv[2])

    # make union
    union = first.union(second)

    # make asOnePartition again
    asOnePartition = union.coalesce(1)

    try:
        # to drop it like a text
        asOnePartition.saveAsTextFile(sys.argv[3])

        # to save it like a Pickler
        asOnePartition.saveAsPickleFile(sys.argv[3]+"1")
    except IndexError:
        pass

    try:
        # to like it like a Sequence
        asOnePartition.saveAsSequenceFile(sys.argv[4])

        # to throw it like a real Hadoop file
        asOnePartition.saveAsHadoopFile(sys.argv[4]+"1")
    except IndexError:
        pass

    print("I think we done, here")