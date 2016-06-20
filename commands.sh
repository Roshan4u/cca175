!#/bin/bash
# 
# There are examples of running command in shell

# runs spark-submit job with simpleSparkApp.scala
spark-submit --class "SimpleApp" --master local[4] target/sparkwordcount-0.0.1-SNAPSHOT.jar

# runs spark-submit job with fromClouderaApp.scala
spark-submit --class SparkWordCount --master local[2] --deploy-mode client --executor-memory 1g --name wordcount --conf "spark.app.id=wordcount" ./target/sparkwordcount2-0.0.1-SNAPSHOT.jar inputfile.txt 2
