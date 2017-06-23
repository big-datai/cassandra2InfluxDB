package com.jactravel.monitoring.influx

import com.paulgoldbaum.influxdbclient._
/**
  * Created by fayaz on 23.06.17.
  */
class InfluxService(database: String) extends InfluxDBConf {
  private val influxDb = InfluxDB.connect(influxHost, influxPort, influxUsername, influxPassword)
  private val db = influxDb.selectDatabase(database)

  def save(point: Point) = db.write(point)

  def close(): Unit = influxDb.close()
}

object InfluxService {
  def apply(database: String): InfluxService = new InfluxService(database)
}
