# Excercise 1 - Setup Kafka

Zookeeper + Kafka is setup via the docker-compose.yml file  
Usage: "docker-compose up"

## Define Topic

To define a topic the following script must be run once:  
*./createTopic.sh* - will create a topic with following default params: topicname=movieData partitionCnt=3 replicationCnt=1

## Publish Data

In order to publish some random movie names created from some data files run:  
*./producer.sh* - Will use the "generateMovieNames.sh" script, which creates random movie names from some pregenerated data and publishes to kafka

The *producer.sh* script for the movieData topic will be expanded with additional attributes like genre, reviews, etc for the next excercises..

## Consumer

In order to see the published data the following script can be used to view all published messages via commandline:  
*./consumer.sh*

# Analyzing the relations between brokers, partitions, replicas & in.sync.replica 

A Kafka Cluster consists of brokers  

Partitions: Partitions are created in order to enable data parallelism  

Replicas: Partitions can have replicas in order to ensure data durability and availability; 1 Replica can only be owned by 1 broker, so the replica count can never be higher than the broker count -> __replica count <= broker count__  

in.sync.replica: The amount of replicas, who are in sync with the "leader", so in.sync.replica can never be higher than the replica count -> __in.sync.replica <= Replica__

# Excercise 2 - Setup a stream with one aggregation

Zookeeper + Kafka + Schema registry is setup via the docker-compose.yml file
Usage: "docker-compose up"

Also use "mvn clean install" in order to generate the POJO files.

## Publish Data

In order to publish some movie data start the KafkaApplication and send your own Movies via http://localhost:8080/api/v1/kafka/sendMovie API  
with example json:  
{  
"movieName":"TEST",  
"genre":"genreTest",  
"rating":5,  
"views":100  
}  

## Consumer
The published data is logged in the terminal  

# How is the schema validated based on your selected compatibility mode.

Schema validation is the process of ensuring that the structure of a schema is consistent and conforms to the  
compatibility mode selected. In the case of AVRO, the schema validation process involves using the schema  
registry to validate the schema against the compatibility mode selected. We use Full compatibility mode
which means a new schema is fully compatible with an old schema if its backward and forward compatible.  
Backward means we can delete fields and add optional fields and Forward means we can Add fields and delete  
optional fields. Therefore with Full compatibility adding and deleting optional fields is allowed.