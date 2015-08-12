package org.tresamigos.smvperftest.perftest

import org.tresamigos.smvperftest.core._
import org.tresamigos.smvperftest.etl._
import org.tresamigos.smv._

object ReadTest extends SmvModule("Read single local file and line count") {

  override def version() = 0;
  override def requiresDS() = Seq(PerfTestApp.trnx);

  override def run(i: runParams) = {
    val srdd = i(PerfTestApp.trnx)
    import srdd.sqlContext.implicits._

    val n = srdd.count
    println(s"Total Count: $n")

    srdd.sqlContext.emptyDataFrame
  }
  /* ~20 min Apple Air I7 */
}

object GzReadTest extends SmvModule("Read single Gzipped local file and line count") {

  override def version() = 0;
  override def requiresDS() = Seq(PerfTestApp.trnxgz);

  override def run(i: runParams) = {
    val srdd = i(PerfTestApp.trnxgz)
    import srdd.sqlContext.implicits._

    val n = srdd.count
    println(s"Total Count: $n")

    srdd.sqlContext.emptyDataFrame
  }
  /* ~35 min Apple Air I7 */
}
