package videogamedb.scriptfundamentals;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;
import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class VideoGameDb extends Simulation {

    public static final String VIDEOGAME = "/videogame";
    public static final String GET_ALL_VIDEOS_GAMES = "Get all videos games ";
    public static final String GET_SPECIFIC_GAME = "Get specific game";
    public static final String GAME_ID = "gameId";
    public static final String RESPONSE_BODY = "responseBody";
    // 1 Http Configuration
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json");

    // 2 Scenario Definition
    private ScenarioBuilder scn = scenario("Video Game Db - section 5 code")

            .exec(http(GET_SPECIFIC_GAME)
                    .get("/videogame/1")
                    .check(status().in(200, 201,202))
                    .check(jmesPath("name").is("Resident Evil 4")))
            .pause(1,10)
            
            .exec(http(GET_ALL_VIDEOS_GAMES)
                    .get(VIDEOGAME)
                    .check(status().not(404),status().not(500))
                    .check(jmesPath("[1].id").saveAs(GAME_ID)))
            .pause(Duration.ofMillis(4000))
            .exec(
                    session -> {
                        System.out.println(session);
                        System.out.println("gameId set to: "+ session.getString(GAME_ID));
                        return session;
                    }
            )

            .exec(http(GET_SPECIFIC_GAME +" with Id - #{"+GAME_ID+"}")
                    .get("/videogame/#{"+GAME_ID+"}")
                    .check(jmesPath("name").is("Gran Turismo 3"))
                    .check(bodyString().saveAs(RESPONSE_BODY)))
            .exec(
                    session -> {
                        System.out.println("Response Body: " + session.getString(RESPONSE_BODY));
                        return session;
                    }
            );



    // 3 Load Simulation
    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }

}
