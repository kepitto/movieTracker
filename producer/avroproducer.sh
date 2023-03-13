#!/bin/bash


while true
do
echo '{"id": 10, "MovieName": "RANDOMMOVIENAME", "Rating" : 3.6, "Genre":"ROCK"}' | sudo docker exec --interactive schema-registry kafka-avro-console-producer --broker-list broker:29092 --topic movieData --property value.schema="$(< ./schemas/movie-schema.avsc)"
sleep 1s
done
