package com.whisk.docker

import com.whisk.docker.specs2.DockerTestKit
import org.specs2._
import org.specs2.specification.core.Env
import scala.concurrent._
import scala.concurrent.duration._

import org.specs2.concurrent.ExecutionEnv

class Neo4jServiceSpec(env: Env)
    extends Specification
    with DockerTestKitDockerJava
    with DockerTestKit
    with DockerNeo4jService {

  implicit val ee: ExecutionEnv = env.executionEnv
  implicit val ec: ExecutionContext = env.executionContext

  def is = s2"""
  The neo4j container should
    be ready                     $x1
                                 """

  def x1 = isContainerReady(neo4jContainer) must beTrue.await
}
