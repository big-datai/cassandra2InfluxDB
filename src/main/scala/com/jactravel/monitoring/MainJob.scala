package com.jactravel.monitoring

import com.jactravel.monitoring.influx.InfluxModels._
import com.jactravel.monitoring.influx.InfluxService
import com.jactravel.monitoring.utils.Configuration._
import com.jactravel.monitoring.utils.SparkConfiguration

/**
  * Created by fayaz on 23.06.17.
  */
object MainJob extends App with SparkConfiguration {

  private val params = Map(
    "keyspace" -> cassandraKeySpace,
    "table" -> cassandraTable
  )

  val df = spark
    .read
    .format("org.apache.spark.sql.cassandra")
    .options(params)
    .load()

  df.foreachPartition { partition =>
    val conn = InfluxService("test")

    partition
      .map(r => toTestPoint("cpu", r))
      .foreach(conn.save)

    conn.close()
  }

  spark.stop()
}
