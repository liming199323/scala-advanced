package com.gourd.scala.base.self_types

import org.slf4j.LoggerFactory

/**
  * 自类型
  * 用于声明一个特质必须混入其他特质，尽管该特质没有直接扩展其他特质。 这使得所依赖的成员可以在没有导入的情况下使用。
  * 自类型是一种细化 this 或 this 别名之类型的方法。 语法看起来像普通函数语法，但是意义完全不一样。
  * 要在特质中使用自类型，写一个标识符，跟上要混入的另一个特质，以及 =>（例如 someIdentifier: SomeOtherTrait =>）。
  * @author Li.Wei by 2019-08-06
  */
object MyApp {
  private val logger = LoggerFactory.getLogger("MyApp")

  def main(args: Array[String]): Unit = {}

  /**
    * 示例
    */
  {
    trait User {
      def username: String
    }

    trait Tweeter {
      this: User => // 重新赋予 this 的类型，因此username可以再tweet方法中使用
      def tweet(tweetText: String) = println(s"$username: $tweetText")
    }
    // 因为VerifiedTweeter继承了Tweeter，而Tweeter又指定了自类型User，所以VerifiedTweeter还需要混入User
    class VerifiedTweeter(val username_ : String) extends Tweeter with User {
      def username = s"real $username_"
    }

    val realBeyoncé = new VerifiedTweeter("Beyoncé")
    realBeyoncé.tweet("Just spilled my glass of lemonade")
    // real Beyoncé: Just spilled my glass of lemonade
  }

  /**
    * 示例2
    * 用在有内部类的情况
    */
  {
    class Outer {
      out =>
      val v1 = "spark"

      class Inner {
        println(out.v1) // 用outer表示外部类，相当于Outer.this
      }

    }
  }
}
