package com.jactravel.monitoring.configs

import com.typesafe.config.ConfigFactory

/**
  * Created by fayaz on 23.06.17.
  */
object Configuration {

  private val config = ConfigFactory.load()

  private[configs] val appName = config.getString("spark.appName")

  private[configs] val appMaster = config.getString("spark.master")

  private[configs] val cassandraHost = config.getString("cassandra.host")

  private[configs] val cassandraPort = config.getString("cassandra.port")

  private[configs] val cassandraUsername = config.getString("cassandra.username")

  private[configs] val cassandraPassword = config.getString("cassandra.password")

  val cassandraKeySpace: String = config.getString("cassandra.keyspace")

  val cassandraTable: String = config.getString("cassandra.tableName")

}
