name := "ScalaMemAdmin"

version := "1.0"

scalaVersion := "2.11.4"

resolvers ++= Seq(
  "Spy Memcached" at "http://files.couchbase.com/maven2"
)

libraryDependencies ++= Seq(
  "spy" % "spymemcached" % "2.7.3",
  "com.bionicspirit" %% "shade" % "1.6.0",
  "org.scalafx" %% "scalafx" % "8.0.20-R6"
)
