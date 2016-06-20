# first we get our text file into RDD
val textFile = sc.textFile("derby.log")

# then we check simple actions on it

# get first line
textFile.first()
# res1: String = Mon Jun 20 00:24:10 PDT 2016 Thread[main,5,main] Ignored duplicate property derby.module.replication.master in jar:file:/usr/jars/derby-10.11.1.1.jar!/org/apache/derby/modules.properties

# count lines
textFile.count()
# res0: Long = 76

# make simple transformations, this creates new RDD
# count all lines with query word
val linesWithWord = textFile.filter(line => line.contains("word"))

# to check our results
linesWithWord.count()
# res2: Long = 63

# OR chain together transformations and actions
textFile.filter(line => line.contains("word")).count()
# res3: Long = 63

# more about RDD operations
# here are where Map and Reduce starts

# to get length of the maximum-words-line
textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)
# res4: Int = 16

# Map function can be any function from elsewhere
import java.lang.Math
textFile.map(line => line.split(" ").size).reduce((a, b) => Math.max(a, b))

# common data flow pattern - MapReduce
val wordCounts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
# this computes per-word counts as an RDD (String, Int) pairs
# to collect our words in shell we use collect()
wordCounts.collect()
# res7: Array[(String, Int)] = Array((derby.module.tcf,1), (Software,1), (derby.module.validation,1), (derby.module.optimizer,1), (derby.module.mgmt.jmx,1), (derby.module.rawStore.data.genericJ1,1), (The,1), (derby.module.replication.master,1), (derby.env.jdk.cryptographyJ2,1), (Derby,2), (derby.module.resourceAdapterJ2,1)...
