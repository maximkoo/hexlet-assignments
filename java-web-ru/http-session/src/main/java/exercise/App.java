package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        List<Map<String, String>> res = new ArrayList<>();
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page",String.class).getOrDefault("1");
            var per = ctx.queryParamAsClass("per",String.class).getOrDefault("5");
            int npage=Integer.parseInt(page)-1;
            int nper=Integer.parseInt(per);
            res.clear();
            for (int i=0; i<USERS.size(); i++){
                //if (i>((Integer.parseInt(page)-1)*Integer.parseInt(per)) && i<=((Integer.parseInt(page)-1)*Integer.parseInt(per)+Integer.parseInt(per))){
                int id = Integer.parseInt(USERS.get(i).get("id"));
                if ((i>=npage*nper) && (i<npage*nper+nper)){
                    System.out.println(i);
                    res.add(USERS.get(i));
                }
            }
            //System.out.println("QQQQQQQQQQQQQQQQQQQ"+res);
            ctx.json(res);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
