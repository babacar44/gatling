package videogamedb;

import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class RecordedSimulationProxy extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://videogamedb.uk")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*", ".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .userAgentHeader("PostmanRuntime/7.35.0");
  
  private Map<CharSequence, String> headers_0 = Map.of("Postman-Token", "49361ebb-bb85-4537-b63e-dab788df6868");
  
  private Map<CharSequence, String> headers_1 = Map.of("Postman-Token", "4b32f227-285e-4773-9ef4-675eba5d1230");
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "4a787abe-69e6-42e8-879e-76e89462555f")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "83192096-38fc-445d-b1ac-a95ec932fe99"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjExODQ0MSwiZXhwIjoxNzAyMTIyMDQxfQ.uNSy9nKxQ9BgR-H7lTDs-A5Cv-YHnl5dSNLBcpLOYok")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Postman-Token", "9a2075ab-65b4-4445-9c86-4008463de8a6"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjExODQ0MSwiZXhwIjoxNzAyMTIyMDQxfQ.uNSy9nKxQ9BgR-H7lTDs-A5Cv-YHnl5dSNLBcpLOYok")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Postman-Token", "98fcacb0-c98a-49ed-8220-b86328e82a87"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjExODQ0MSwiZXhwIjoxNzAyMTIyMDQxfQ.uNSy9nKxQ9BgR-H7lTDs-A5Cv-YHnl5dSNLBcpLOYok")
  );


  private ScenarioBuilder scn = scenario("RecordedSimulationProxy")
    .exec(
      http("request_0")
        .get("/api/videogame")
        .headers(headers_0)
    )
    .pause(34)
    .exec(
      http("request_1")
        .get("/api/videogame/2")
        .headers(headers_1)
    )
    .pause(5)
    .exec(
      http("request_2")
        .post("/api/authenticate")
        .headers(headers_2)
        .body(RawFileBody("videogamedb/recordedsimulationproxy/0002_request.json"))
    )
    .pause(6)
    .exec(
      http("request_3")
        .post("/api/videogame")
        .headers(headers_3)
        .body(RawFileBody("videogamedb/recordedsimulationproxy/0003_request.json"))
    )
    .pause(11)
    .exec(
      http("request_4")
        .put("/api/videogame/3")
        .headers(headers_4)
        .body(RawFileBody("videogamedb/recordedsimulationproxy/0004_request.json"))
    )
    .pause(4)
    .exec(
      http("request_5")
        .delete("/api/videogame/2")
        .headers(headers_5)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
