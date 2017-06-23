package com.jactravel.monitoring.cassandra

import com.jactravel.monitoring.utils.Configuration._

/**
  * Created by fayaz on 23.06.17.
  */
trait CassandraConf {
  // CASSANDRA
  final val cassandraHost: String = config.getString("cassandra.host")
  final val cassandraPort: Int = config.getInt("cassandra.port")
  final val cassandraUsername: String = config.getString("cassandra.username")
  final val cassandraPassword: String = config.getString("cassandra.password")

  final val cassandraKeySpace: String = config.getString("cassandra.keyspace")
  final val cassandraTable: String = config.getString("cassandra.tableName")
}
