#!/bin/bash
if [ -n $1 ];then
  if [[ $1 == "enum" ]];then
     rm -rf ../hke-restful-facade/src/main/java/com/jiejing/protocol/enumtype
      ./butterfly --output ../hke-restful-facade/src/main/java --package com.jiejing.protocol --writer SpringMVC --input ../hke-restful-facade/protocol/enum
  else
     echo 'Usage:'
     echo './gen.sh enum 生成JAVA枚举'
  fi
fi
