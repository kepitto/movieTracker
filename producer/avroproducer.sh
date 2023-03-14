#!/bin/bash



while true
do
id=$((RANDOM % 20000 + 1))
movieName=$(cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 10 | head -n 1)
rating=$(awk -v min=1 -v max=5 'BEGIN{srand(); print min+rand()*(max-min)}')
genres=("Horror" "Action" "Fantasy")
genre=${genres[$((RANDOM % ${#genres[@]}))]}

echo "{\"id\": $id, \"MovieName\": \"$movieName\", \"Rating\" : $rating, \"Genre\":\"$genre\"}" | sudo docker exec --interactive schema-registry kafka-avro-console-producer --broker-list broker:29092 --topic movieData --property value.schema="$(< ../schemas/movie-schema.avsc)"
sleep 1s
done
