package com.jactravel.monitoring.influx

import com.jactravel.monitoring.utils.Configuration.config

/**
  * Created by fayaz on 23.06.17.
  */
trait InfluxDBConf {
  // INFLUXDB
  private[influx] val influxHost = config.getString("influxdb.host")
  private[influx] val influxPort = config.getInt("influxdb.port")
  private[influx] val influxUsername = config.getString("influxdb.username")
  private[influx] val influxPassword = config.getString("influxdb.password")
}
