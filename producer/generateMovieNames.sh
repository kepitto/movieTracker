#!/bin/bash

FILE1="./data/names"
FILE2="./data/nameEnd"

LINES1=$(wc -l < $FILE1)
LINES2=$(wc -l < $FILE2)

RANDOM_LINE1=$((1 + RANDOM % $LINES1))
RANDOM_LINE2=$((1 + RANDOM % $LINES2))

WORD1=$(sed -n "${RANDOM_LINE1}p" $FILE1)
WORD2=$(sed -n "${RANDOM_LINE2}p" $FILE2)

echo "$WORD1 $WORD2"
