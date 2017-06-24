package com.jactravel.monitoring.utils

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by fayaz on 23.06.17.
  */
object Configuration {

  final val config: Config = ConfigFactory.load()

  // SPARK
  final val appName: String = config.getString("spark.appName")
  final val appMaster: String = config.getString("spark.master")

  // CASSANDRA
  final val cassandraHost: String = config.getString("cassandra.host")
  final val cassandraPort: Int = config.getInt("cassandra.port")
  final val cassandraUsername: String = config.getString("cassandra.username")
  final val cassandraPassword: String = config.getString("cassandra.password")

  final val cassandraKeySpace: String = config.getString("cassandra.keyspace")
  final val cassandraTable: String = config.getString("cassandra.tableName")

  // INFLUXDB
  final val influxHost: String = config.getString("influxdb.host")
  final val influxPort: Int = config.getInt("influxdb.port")
  final val influxUsername: String = config.getString("influxdb.username")
  final val influxPassword: String = config.getString("influxdb.password")
}
