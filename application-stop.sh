#!/bin/bash

echo "stopping all java processes"
ps aux | grep java
sudo pkill java

echo "removing app fat jar from /opt"
sudo ls -la /opt/
sudo rm -f /opt/*.jar
exit 0
