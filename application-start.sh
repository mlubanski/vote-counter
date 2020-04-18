#!/bin/bash

"starging app from fat jar"
ls -la /opt/vote-counter-*.jar
nohup java -jar /opt/vote-counter-*.jar /dev/null 2> /dev/null < /dev/null & 