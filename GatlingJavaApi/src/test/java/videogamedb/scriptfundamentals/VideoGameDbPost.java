package videogamedb.scriptfundamentals;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class VideoGameDbPost extends Simulation {

    // 1 Http Configuration
    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://videogamedb.uk/api")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");
    private static ChainBuilder authenticate =
            exec(http("Authenticate")
                    .post("/authenticate")
                    .body(StringBody(
                            "{\n" +
                                    "    \"username\": \"admin\",\n" +
                                    "    \"password\": \"admin\"\n" +
                                    "}"
                    ))
                    .check(jmesPath("token").saveAs("jwtToken"))
            );
    private static ChainBuilder createNewGame =
            exec(http("Create New Game")
                    .post("/videogame")
                    .header("Authorization", "Bearer #{jwtToken}")
                    .body(StringBody(
                            "{\n" +
                                    "    \"id\": 0,\n" +
                                    "    \"name\": \"Mario\",\n" +
                                    "    \"releaseDate\": \"2012-05-04\",\n" +
                                    "    \"reviewScore\": 85,\n" +
                                    "    \"category\": \"Platform\",\n" +
                                    "    \"rating\": \"Mature\"\n" +
                                    "}"
                    )));

    // 2 Scenario Definition
    private final ScenarioBuilder scn = scenario("Video Game Db - section 5 code")
            .exec(authenticate)
            .exec(createNewGame);

    // 3 Load Simulation
    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }

}
