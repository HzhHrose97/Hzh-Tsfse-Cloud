#!/bin/sh

# 停止应用程序
PID=$(ps -ef | grep java | grep hzhCentre | grep -v grep | awk '{print $2}')
if [ "$PID" != "" ]; then
    kill -TERM $PID
    echo "hzhCentre 正在退出..."
    while [ "$PID" != "" ]; do
        sleep 1
        PID=$(ps -ef | grep java | grep hzhCentre | grep -v grep | awk '{print $2}')
    done
    echo "hzhCentre 已停止."
else
    echo "hzhCentre 已停止."
fi