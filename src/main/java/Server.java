import io.javalin.Javalin;

public class Server {
    public static void start() {
        var app = Javalin.create().start(8888);
        app.get("/", ctx -> ctx.result("Hello from HAI MP23"));
        app.get("/encode/{str}", ctx -> ctx.result(Hex.encode(ctx.pathParam("str"))));
    }

    public static void main(String[] args) {
        start();
    }
}
