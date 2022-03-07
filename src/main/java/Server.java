import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Server {
    public static void start() {
        var app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public", Location.CLASSPATH);
            config.addSinglePageRoot("/", "/public/index.html");
        }).start(8888);
        app.get("/api/encode/{str}", ctx -> ctx.result(Hex.encode(ctx.pathParam("str"))));
    }

    public static void main(String[] args) {
        start();
    }
}
