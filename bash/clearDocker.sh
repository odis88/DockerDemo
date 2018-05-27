#!/usr/bin/env bash
docker rm $(docker container ls --all -a -q)
docker image rm $(docker images -a -q) --force