package com.jactravel.monitoring.influx

import com.jactravel.monitoring.utils.Configuration._
import com.jactravel.monitoring.utils.Helper.await
import com.paulgoldbaum.influxdbclient._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

/**
  * Created by fayaz on 23.06.17.
  */
class InfluxService(database: String) {

  implicit val timeout: FiniteDuration = 1 seconds

  private val influxDb = InfluxDB.connect(influxHost, influxPort)
  private val db = influxDb.selectDatabase(database)

  def save(point: Point): Boolean = await { db.write(point) }

  def saveAsync(point: Point): Future[Boolean] = db.write(point)

  def close(): Unit = influxDb.close()
}

object InfluxService {
  def apply(database: String): InfluxService = new InfluxService(database)
}
