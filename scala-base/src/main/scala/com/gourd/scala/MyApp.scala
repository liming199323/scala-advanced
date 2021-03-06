package com.gourd.scala

import org.slf4j.LoggerFactory

/**
  * @author Li.Wei by 2019-08-06
  */
object MyApp {
  private val logger = LoggerFactory.getLogger("MyApp")

  def main(args: Array[String]): Unit = {}

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  // 示例分割注释
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  logger.info("------------------------> block line [1] <----------------------------")

  { //
  }

  logger.info("------------------------> block line [2] <----------------------------")

  { //
  }

  logger.info("------------------------> block line [3] <----------------------------")

  { //
  }

}
