package com.jactravel.monitoring.utils

import com.jactravel.monitoring.utils.Configuration._
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by fayaz on 23.06.17.
  */
trait SparkConfiguration {

  val sparkConf = new SparkConf()
    .setAppName(appName)
    .setMaster(appMaster)
    .set("spark.cassandra.connection.host", cassandraHost)
    .set("spark.cassandra.connection.port", cassandraPort.toString)
    .set("spark.cassandra.auth.username", cassandraUsername)
    .set("spark.cassandra.auth.password", cassandraPassword)

  val sc = new SparkContext(sparkConf)

}
