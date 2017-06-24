package com.jactravel.monitoring.utils

import scala.concurrent.duration.FiniteDuration
import scala.concurrent.{Await, Future}

/**
  * Created by fayaz on 24.06.17.
  */
object Helper {

  def await[T](f: Future[T])(implicit timeout: FiniteDuration): T = Await.result[T](f, timeout)
}
