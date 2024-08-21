#!/bin/bash

choral epp -s src/main/choral -t src/main/java Link
mvn compile
java -cp target/classes saga.Main
