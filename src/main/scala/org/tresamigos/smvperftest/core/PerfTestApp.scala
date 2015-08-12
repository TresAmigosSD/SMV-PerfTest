package org.tresamigos.smvperftest.core

import org.tresamigos.smv._

/** define all the raw inputs into the App */
object PerfTestApp {
  val ca = CsvAttributes.defaultCsvWithHeader

  val trnx = SmvCsvFile("input/transactions", ca)
  val trnxgz = SmvCsvFile("input/transactions.gz", ca)
}
