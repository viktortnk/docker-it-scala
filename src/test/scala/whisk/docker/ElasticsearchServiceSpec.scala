package whisk.docker

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time._
import whisk.docker.test.DockerTestKit

class ElasticsearchServiceSpec extends FlatSpec with Matchers with BeforeAndAfterAll with GivenWhenThen with ScalaFutures
    with DockerTestKit
    with DockerConfig
    with DockerElasticsearchService {

  implicit val pc = PatienceConfig(Span(20, Seconds), Span(1, Second))

  "elasticsearch container" should "be ready" in {
    elasticsearchContainer.isReady().futureValue shouldBe true
  }

}
