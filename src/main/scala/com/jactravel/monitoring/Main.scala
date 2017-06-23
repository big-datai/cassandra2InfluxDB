package com.jactravel.monitoring

import com.datastax.spark.connector.streaming._
import com.jactravel.monitoring.configs.Configuration._
import com.jactravel.monitoring.configs.SparkConfiguration

/**
  * Created by fayaz on 23.06.17.
  */
object Main extends App with SparkConfiguration {
  ssc.cassandraTable(cassandraKeySpace, cassandraTable)

  ssc.start()
  ssc.awaitTermination()
}
