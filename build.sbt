name := "cassandra2InfluxDB"
version := "1.0"
scalaVersion := "2.11.8"


lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)

packageName in Docker := "cassandra2InfluxDB"
version in Docker := "latest"
dockerRepository := Some("faiaz")

lazy val Versions = new {
  val spark = "2.1.1"
}

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",
  "org.apache.spark" % "spark-core_2.11" % Versions.spark,
  "org.apache.spark" % "spark-sql_2.11" % Versions.spark,
  "com.datastax.spark" % "spark-cassandra-connector_2.11" % "2.0.2",
  "com.paulgoldbaum" %% "scala-influxdb-client" % "0.5.2"
)