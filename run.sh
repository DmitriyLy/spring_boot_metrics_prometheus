#!/bin/bash

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8181 -jar target/app.jar
