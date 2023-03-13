#!/bin/bash

sudo docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic movieData --from-beginning
