package com.jactravel.monitoring.utils

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by fayaz on 23.06.17.
  */
object Configuration {
  final val config: Config = ConfigFactory.load()
}
