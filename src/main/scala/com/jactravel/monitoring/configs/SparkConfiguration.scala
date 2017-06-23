package com.jactravel.monitoring.configs

import com.jactravel.monitoring.configs.Configuration._
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by fayaz on 23.06.17.
  */
trait SparkConfiguration {

  val sparkConf = new SparkConf()
    .setAppName(appName)
    .setMaster(appMaster)
    .set("spark.cassandra.connection.host", cassandraHost)
    .set("spark.cassandra.connection.port", cassandraPort)
    .set("spark.cassandra.auth.username", cassandraUsername)
    .set("spark.cassandra.auth.password", cassandraPassword)

  val sc = new SparkContext(sparkConf)

  val ssc = new StreamingContext(sc, Seconds(1))
}
