package com.jactravel.monitoring.spark

import com.jactravel.monitoring.cassandra.CassandraConf
import com.jactravel.monitoring.utils.Configuration._
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by fayaz on 23.06.17.
  */
trait SparkConfiguration extends CassandraConf {

  // SPARK
  private[config] val appName = config.getString("spark.appName")
  private[config] val appMaster = config.getString("spark.master")

  val sparkConf = new SparkConf()
    .setAppName(appName)
    .setMaster(appMaster)
    .set("spark.cassandra.connection.host", cassandraHost)
    .set("spark.cassandra.connection.port", cassandraPort.toString)
    .set("spark.cassandra.auth.username", cassandraUsername)
    .set("spark.cassandra.auth.password", cassandraPassword)

  val sc = new SparkContext(sparkConf)

  val ssc = new StreamingContext(sc, Seconds(1))
}
