#!/bin/bash

test $(curl localhost:8088/sum?a=1\&b=2) -eq 3