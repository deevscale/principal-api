#!/bin/bash
 mvn clean package && docker build -f scripts/Dockerfile -t principal-api:1 . && docker run principal-api:1
