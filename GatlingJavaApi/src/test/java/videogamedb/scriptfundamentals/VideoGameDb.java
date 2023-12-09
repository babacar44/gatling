package videogamedb.scriptfundamentals;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class VideoGameDb extends Simulation {

    public static final String VIDEOGAME = "/videogame";
    public static final String GET_ALL_VIDEOS_GAMES = "Get all videos games ";
    // 1 Http Configuration
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    // 2 Scenario Definition
    private ScenarioBuilder scn = scenario("Video Game Db - section 5 code")
            .exec(http(GET_ALL_VIDEOS_GAMES + "- 1st call")
                    .get(VIDEOGAME))
            .pause(5)

            .exec(http("Get specific game")
                    .get("/videogame/1"))
            .pause(1,10)
            
            .exec(http(GET_ALL_VIDEOS_GAMES + "- 2nd call")
                    .get(VIDEOGAME))
            .pause(Duration.ofMillis(4000));

    // 3 Load Simulation
    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }

}
