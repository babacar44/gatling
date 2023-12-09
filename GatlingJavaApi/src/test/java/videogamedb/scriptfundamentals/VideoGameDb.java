package videogamedb.scriptfundamentals;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class VideoGameDb extends Simulation {

    public static final String GET_ALL_VIDEOS_GAMES = "Get all videos games ";
    public static final String GET_SPECIFIC_GAME = "Get specific game";
    public static final String VIDEO_GAME_ENDPT = "/videogame";
    // 1 Http Configuration
    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    private static final ChainBuilder getAllVideoGames =
            repeat(3).on(
                    exec(http(GET_ALL_VIDEOS_GAMES)
                            .get(VIDEO_GAME_ENDPT)
                            .check(status().not(404), status().not(500)))
            );

    private static final ChainBuilder getSpecificVideoGame =
            repeat(5, "myCounter").on(
                    exec(http(GET_SPECIFIC_GAME+ "with id: #{myCounter}")
                            .get(VIDEO_GAME_ENDPT + "/#{myCounter}")
                            .check(status().is(200)))
            );
    // 2 Scenario Definition
    private final ScenarioBuilder scn = scenario("Video Game Db - section 5 code")
            .exec(getAllVideoGames)
            .pause(5)
            .exec(getSpecificVideoGame)
            .pause(5)
            .repeat(2).on(
                    exec(getAllVideoGames)
            );

    // 3 Load Simulation
    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }

}
