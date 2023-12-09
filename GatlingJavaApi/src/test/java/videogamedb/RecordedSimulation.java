package videogamedb;

import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class RecordedSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://www.videogamedb.uk")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("application/json")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Mobile Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("origin", "https://www.videogamedb.uk"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"118\", \"Google Chrome\";v=\"118\", \"Not=A?Brand\";v=\"99"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKy1yQEIi7bJAQiktskBCKmdygEIkYHLAQiWocsBCIWgzQEIuMjNAQi5ys0BCMDUzQEYj87NARjV3M0B")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"118\", \"Google Chrome\";v=\"118\", \"Not=A?Brand\";v=\"99"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("content-type", "text/plain;charset=UTF-8"),
    Map.entry("origin", "https://www.videogamedb.uk"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"118\", \"Google Chrome\";v=\"118\", \"Not=A?Brand\";v=\"99"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKy1yQEIi7bJAQiktskBCKmdygEIkYHLAQiWocsBCIWgzQEIuMjNAQi5ys0BCMDUzQEYj87NARjV3M0B")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Content-Type", "application/json"),
    Map.entry("Origin", "https://www.videogamedb.uk"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("authorization", "Bearer admin"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"118\", \"Google Chrome\";v=\"118\", \"Not=A?Brand\";v=\"99"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private String uri1 = "https://translate.googleapis.com";

  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .exec(
      http("request_0")
        .post(uri1 + "/translate_a/t?anno=3&client=te_lib&format=html&v=1.0&key=AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw&logld=vTE_20231206&sl=en&tl=fr&tc=0&tk=716860.902869")
        .headers(headers_0)
        .formParam("q", "POST")
        .formParam("q", "<a i=0>/api</a><a i=1>/authenticate</a>")
        .formParam("q", "Request authentication token")
        .formParam("q", "post ​/api​/authenticate")
    )
    .pause(4)
    .exec(
      http("request_1")
        .post(uri1 + "/translate_a/t?anno=3&client=te_lib&format=html&v=1.0&key=AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw&logld=vTE_20231206&sl=en&tl=fr&tc=0&tk=946982.607695")
        .headers(headers_0)
        .formParam("q", "GET")
        .formParam("q", "<a i=0>/api</a><a i=1>/videogame</a>")
        .formParam("q", "List all video games")
        .formParam("q", "Create a video game")
        .formParam("q", "<a i=0>/api</a><a i=1>/videogame</a><a i=2>/{id}</a>")
        .formParam("q", "Get a video game")
        .formParam("q", "PUT")
        .formParam("q", "Update a video game")
        .formParam("q", "DELETE")
        .formParam("q", "Delete a video game")
        .formParam("q", "get ​/api​/videogame")
        .formParam("q", "post ​/api​/videogame")
        .formParam("q", "authorization button locked")
        .formParam("q", "get ​/api​/videogame​/{id}")
        .formParam("q", "put ​/api​/videogame​/{id}")
        .formParam("q", "delete ​/api​/videogame​/{id}")
    )
    .pause(2)
    .exec(
      http("request_2")
        .post(uri1 + "/translate_a/t?anno=3&client=te_lib&format=html&v=1.0&key=AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw&logld=vTE_20231206&sl=en&tl=fr&tc=0&tk=280850.229371")
        .headers(headers_0)
        .formParam("q", "Parameters")
        .formParam("q", "Try it out ")
        .formParam("q", "No parameters")
        .formParam("q", "Possible responses")
        .formParam("q", "Code")
        .formParam("q", "Description")
        .formParam("q", "Links")
        .formParam("q", "200")
        .formParam("q", "OK")
        .formParam("q", "Media type")
        .formParam("q", "application/json")
        .formParam("q", "<a i=0>Controls </a><a i=1> header.</a>")
        .formParam("q", "Example Value")
        .formParam("q", "Schema")
        .formParam("q", "No links")
        .formParam("q", "Media Type")
    )
    .pause(15)
    .exec(
      http("request_3")
        .get("/api/videogame")
        .headers(headers_3)
    )
    .pause(3)
    .exec(
      http("request_4")
        .post(uri1 + "/element/log?hasfast=true&authuser=0&format=json")
        .headers(headers_4)
        .body(RawFileBody("videogamedb/recordedsimulation/0004_request.txt"))
    )
    .pause(52)
    .exec(
      http("request_5")
        .post("/api/videogame")
        .headers(headers_5)
        .body(RawFileBody("videogamedb/recordedsimulation/0005_request.json"))
        .check(status().is(500))
    )
    .pause(32)
    .exec(
      http("request_6")
        .get("/api/videogame/2")
        .headers(headers_3)
    )
    .pause(16)
    .exec(
      http("request_7")
        .put("/api/videogame/2")
        .headers(headers_5)
        .body(RawFileBody("videogamedb/recordedsimulation/0007_request.json"))
        .check(status().is(500))
    )
    .pause(9)
    .exec(
      http("request_8")
        .get("/api/videogame")
        .headers(headers_3)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
