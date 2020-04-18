#!/bin/bash

"starging app from fat jar"
ls -la /opt/vote-counter-*.jar
nohup java -jar /opt/vote-counter-*.jar &
