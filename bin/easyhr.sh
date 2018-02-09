#!/bin/bash

appName=$2

if [ "$1" = "" ];
then
    echo -e "请输入操作名{start|stop|restart|status}"
    exit 1
fi

if [ "$appName" = "" ];
then
    echo -e "请输入应用名"
    exit 1
fi

function start()
{
    count=`ps -ef |grep java|grep $appName|grep -v grep|wc -l`
    if [ $count != 0 ];then
        echo "$appName is running..."
    else
        echo "Start $appName success..."
        nohup java -jar $appName &
    fi
}

function stop()
{
    echo "Stop $appName"
    boot_id=`ps -ef |grep java|grep $appName|grep -v grep|awk '{print $2}'`
    count=`ps -ef |grep java|grep $appName|grep -v grep|wc -l`

    if [ $count != 0 ];then
        kill $boot_id
        count=`ps -ef |grep java|grep $appName|grep -v grep|wc -l`

        boot_id=`ps -ef |grep java|grep $appName|grep -v grep|awk '{print $2}'`
        kill -9 $boot_id
    fi
}

function restart()
{
    stop
    sleep 2
    start
}

function status()
{
    count=`ps -ef |grep java|grep $appName|grep -v grep|wc -l`
    if [ $count != 0 ];then
        echo "$appName is running..."
    else
        echo "$appName is not running..."
    fi
}

case $1 in
    start)
    start;;
    stop)
    stop;;
    restart)
    restart;;
    status)
    status;;
    *)
esac