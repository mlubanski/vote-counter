#!/bin/bash

echo "stopping all java processes"
ps aux | grep java
pkill java

echo "removing app fat jar from /opt"
ls -la /opt/
rm -f /opt/*.jar
exit 0
