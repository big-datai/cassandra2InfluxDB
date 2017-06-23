package com.jactravel.monitoring.spark

import com.datastax.spark.connector.streaming._
import com.jactravel.monitoring.influx.InfluxService

/**
  * Created by fayaz on 23.06.17.
  */
object StreamingProcess extends App with SparkConfiguration {
  val influxService = InfluxService("test")
  val rdd = ssc.cassandraTable(cassandraKeySpace, cassandraTable)

  ssc.start()
  ssc.awaitTermination()
}
