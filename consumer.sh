#!/bin/bash

sudo docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic movies --from-beginning
