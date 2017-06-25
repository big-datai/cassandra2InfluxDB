package com.jactravel.monitoring.utils

import com.datastax.spark.connector.cql.CassandraConnectorConf
import com.jactravel.monitoring.utils.Configuration._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.cassandra._


/**
  * Created by fayaz on 23.06.17.
  */
trait SparkConfiguration {

  final val sparkConf: SparkConf = new SparkConf()
    .setAppName(appName)
    .setMaster(appMaster)

  final val spark: SparkSession = SparkSession
    .builder()
    .config(sparkConf)
    .getOrCreate()
    .setCassandraConf(
      CassandraConnectorConf.ConnectionHostParam.option(cassandraHost) ++
      CassandraConnectorConf.ConnectionPortParam.option(cassandraPort) ++
      CassandraConnectorConf.KeepAliveMillisParam.option(10000))
}
