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