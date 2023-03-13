#!/bin/bash


while true
do
./generateMovieNames.sh | sudo docker exec --interactive broker kafka-console-producer --bootstrap-server broker:9092 --topic movieData
sleep 1s
done
