package com.whisk.docker.testkit.test

import com.whisk.docker.testkit._
import org.scalatest.funsuite.AnyFunSuite

class MultiContainerTest
    extends AnyFunSuite
    with DockerElasticsearchService
    with DockerMongodbService {

  override val managedContainers: ContainerGroup =
    ContainerGroup.of(elasticsearchContainer, mongodbContainer)

  test("both containers should be ready") {
    assert(
      elasticsearchContainer.state().isInstanceOf[ContainerState.Ready],
      "elasticsearch container is ready"
    )
    assert(elasticsearchContainer.mappedPortOpt(9200).nonEmpty, "elasticsearch port is exposed")

    assert(mongodbContainer.state().isInstanceOf[ContainerState.Ready], "mongodb is ready")
    assert(mongodbContainer.mappedPortOpt(27017).nonEmpty, "port 2017 is exposed")
  }
}
