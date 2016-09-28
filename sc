#!/bin/bash

set -e

if [ $# -ne 2 ]; then
	echo 'sc user ip'
	exit 1
fi

if [[ $2 =~ ^[0-9]+\.[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
	/usr/bin/xfreerdp +clipboard /u:$1 /size:1664x936 /kbd:0x0000040C /title:$2 /v:$2 /drive:home,/home/paul/ /cert-ignore
else
  	ip=$(host $2 | grep -v arpa | awk '{ print $4 }')
	echo $ip
	/usr/bin/xfreerdp +clipboard /u:$1 /size:1664x936 /kbd:0x0000040C /title:$2 /v:$ip /drive:home,/home/paul/ /cert-ignore
fi
