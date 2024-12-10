package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN

        app.get("/companies/{id}", ctx -> {
            var vid = ctx.pathParam("id");

            Map<String, String> company = new HashMap<>();
//            for (Map<String, String> m : COMPANIES){
//                if (m.get("id").equals(vid)){
//                    company = m;
//                }
//            }
            company = COMPANIES.stream()
                               .filter(e -> e.get("id").equals(vid))
                               .findFirst()
                               //.orElse(null);
                               .orElseThrow(() -> new NotFoundResponse("Company not found"));
            ctx.json(company);
        });
            //var page = ctx.queryParamAsClass("page",String.class).getOrDefault("1");
            //var per = ctx.queryParamAsClass("per",String.class).getOrDefault("5");
            //int npage=Integer.parseInt(page)-1;
            //int nper=Integer.parseInt(per);
            //res.clear();
            //for (int i=0; i<USERS.size(); i++){
                //if (i>((Integer.parseInt(page)-1)*Integer.parseInt(per)) && i<=((Integer.parseInt(page)-1)*Integer.parseInt(per)+Integer.parseInt(per))){
                //int id = Integer.parseInt(USERS.get(i).get("id"));
                //if ((i>=npage*nper) && (i<npage*nper+nper)){
                    //System.out.println(i);
                    //res.add(USERS.get(i));
                //}
            //}
            //System.out.println("QQQQQQQQQQQQQQQQQQQ"+res);
            //ctx.json(res);
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
