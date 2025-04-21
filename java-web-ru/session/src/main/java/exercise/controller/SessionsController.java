package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Generator;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        String userName = ctx.sessionAttribute("currentUser");
        if (userName == null){
            ctx.render("build.jte");
        } else {
            var page = new LoginPage(userName, null);
            ctx.render("index.jte", model("page", page));
        }
    }

    public static void create(Context ctx) {
        var userName = ctx.formParam("name");
        var password = ctx.formParam("password");

        // Тут должна быть проверка пароля
        User user = Generator.getUsers().stream().filter(x -> x.getName().equals(userName)).findFirst().orElse(null);
        if (user == null){
            var page = new LoginPage(null, null);
            ctx.render("index.jte", model("page", page));
        } else {
            if (user.getPassword().equals(encrypt(password))) {
                ctx.sessionAttribute("currentUser", userName);
                var page = new LoginPage(userName, null);
                ctx.render("index.jte", model("page", page)).status(302);
            } else
            {
                var page = new LoginPage(null, null);
                ctx.render("index.jte", model("page", page));
            }
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/sessions/build");
    }
    // END
}
