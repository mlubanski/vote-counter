#!/bin/bash

ps aux | java
pkill java

ls -la /opt/
rm -f /opt/*.jar
