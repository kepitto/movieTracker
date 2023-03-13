#!/bin/bash

topicname=movieData
partitionCnt=3
replicationCnt=1

sudo docker exec broker kafka-topics --bootstrap-server broker:9092 --create --topic ${topicname} --partitions ${partitionCnt} --replication-factor ${replicationCnt}
