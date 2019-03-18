import java.io.File
import java.net.URI
import java.util.Locale

import scala.tools.nsc.GenericRunnerSettings

import org.apache.spark._
import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.internal.StaticSQLConf.CATALOG_IMPLEMENTATION
import org.apache.spark.util.Utils

object main extends Logging{

    //Manual configuration file.
    //Deprecaded for now.
    //Dynamically loading spark properties

    initializeLogIfNecessary(true)
    Signaling.cancelOnInterrupt()

    val conf = new SparkConf()
    /*val rootDir = conf.getOption("spark.repl.classdir").getOrElse(Utils.getLocalDir(conf))
    val outputDir = Utils.createTempDir(root = rootDir, namePrefix = "repl")*/

    var sparkContext: SparkContext = _
    var sparkSession: SparkSession = _
    

    private var hasErrors = false

    private def scalaOptionError(msg: String): Unit = {
        hasErrors = true
        // scalastyle:off println
        Console.err.println(msg)
        // scalastyle:on println
    }

    def main(args: Array[String]) {
        doMain(args, new SparkILoop)
    }

  // Visible for testing
    private[repl] def doMain(args: Array[String]): Unit = {
        
        val settings = new GenericRunnerSettings(scalaOptionError)

        conf.setMaster("local[2]")//Run locally with 2 threads
        conf.setAppName("DDLSpark")

    }
  

  def createSparkSession(): SparkSession = {
    try {
      val execUri = System.getenv("SPARK_EXECUTOR_URI")
     
      
      if (System.getenv("SPARK_HOME") != null) {
        conf.setSparkHome(System.getenv("SPARK_HOME"))
      }

      val builder = SparkSession.builder.config(conf)
      if (conf.get(CATALOG_IMPLEMENTATION.key, "hive").toLowerCase(Locale.ROOT) == "hive") {
        if (SparkSession.hiveClassesArePresent) {
          // In the case that the property is not set at all, builder's config
          // does not have this value set to 'hive' yet. The original default
          // behavior is that when there are hive classes, we use hive catalog.
          sparkSession = builder.enableHiveSupport().getOrCreate()
          logInfo("Created Spark session with Hive support")
        } else {
          // Need to change it back to 'in-memory' if no hive classes are found
          // in the case that the property is set to hive in spark-defaults.conf
          builder.config(CATALOG_IMPLEMENTATION.key, "in-memory")
          sparkSession = builder.getOrCreate()
          logInfo("Created Spark session")
        }
      } else {
        // In the case that the property is set but not to 'hive', the internal
        // default is 'in-memory'. So the sparkSession will use in-memory catalog.
        sparkSession = builder.getOrCreate()
        logInfo("Created Spark session")
      }
      sparkContext = sparkSession.sparkContext
      sparkSession
    } catch {
      case e: Exception if isShellSession =>
        logError("Failed to initialize Spark session.", e)
        sys.exit(1)
    }
  }

}