package org.tresamigos.smvperftest.etl

import org.tresamigos.smvperftest.core._
import org.tresamigos.smv._

object Trnx1Pct extends SmvModule("1 percent sample of the Transactions") {

  override def version() = 1;
  override def requiresDS() = Seq(PerfTestApp.trnx);

  override def run(i: runParams) = {
    val srdd = i(PerfTestApp.trnx)
    import srdd.sqlContext.implicits._

    val partitions = srdd.sqlContext.getConf("spark.sql.shuffle.partitions", "64").toInt
    /* Since spark 1.3 is not supporting coalesce on DF, we have to workaround.
    For 1.4 it will be just one line
    srdd.smvHashSample($"id", 0.01, 23).coalesce(partitions)*/

    val resRdd = srdd.smvHashSample($"id", 0.01, 23).rdd.coalesce(partitions)
    srdd.sqlContext.createDataFrame(resRdd, srdd.schema)
  }
}
