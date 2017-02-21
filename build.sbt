name := "Trailermovie"

version := "1.0-SNAPSHOT"

resolvers += "asia.chiase" at "http://repo.trente.asia:8081/nexus/content/repositories/snapshots/"

libraryDependencies ++= Seq(
	javaJdbc,
	javaEbean,
	cache,
	"asia.chiase" % "chiase-core" % "2.0-SNAPSHOT",
	"asia.chiase" % "chiase-play-plugin_2.10" % "2.1-SNAPSHOT",
	"mysql" % "mysql-connector-java" % "5.1.34",
	"org.springframework" % "spring-context" % "4.1.1.RELEASE",
	 "net.sf.oval" % "oval" % "1.80",
	 "commons-io" % "commons-io" % "2.3",
	 "org.apache.commons" % "commons-email" % "1.3.1",
	 "org.bouncycastle" % "bcprov-jdk16" % "1.46",
	 	  "org.json" % "org.json" % "chargebee-1.0",
	   "javax.mail" % "javax.mail-api" % "1.5.1"
)     


play.Project.playJavaSettings
