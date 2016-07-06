CREATE TABLE a1 
ROW FORMAT
SERDE 'org.apache.hadoop.hive.serde2.avro.AvroSerDe'
WITH SERDEPROPERTIES (
'avro.schema.url' = 'file:///home/cloudera/cca175/employees.avsc')
STORED AS INPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerInputFormat'
OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.avro.AvroContainerOutputFormat';
LOAD DATA LOCAL INPATH '/user/cloudera/a1' INTO TABLE a1;
