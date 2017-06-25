package com.jactravel.monitoring.influx

import com.paulgoldbaum.influxdbclient.Point
import org.apache.spark.sql.Row

/**
  * Created by fayaz on 23.06.17.
  */
object InfluxModels {
  def toTestPoint(measurement: String, cr: Row): Point = {
    Point(measurement)
      .addField("id", cr.getLong(0))
      .addField("firstName", cr.getString(1))
      .addField("lastName", cr.getString(2))
  }
}
