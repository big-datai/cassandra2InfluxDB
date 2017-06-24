package com.jactravel.monitoring

import com.datastax.spark.connector._
import com.jactravel.monitoring.influx.InfluxModels._
import com.jactravel.monitoring.influx.InfluxService
import com.jactravel.monitoring.utils.Configuration._
import com.jactravel.monitoring.utils.SparkConfiguration

/**
  * Created by fayaz on 23.06.17.
  */
object MainJob extends App with SparkConfiguration {

  // FIRST TABLE
  sc.cassandraTable(cassandraKeySpace, cassandraTable)
    .foreachPartition { partition =>
      val conn = InfluxService("test")
      partition
        .map(cr => toTestPoint("cpu", cr))
        .foreach(conn.save)
      conn.close()
    }

  sc.stop()
}
