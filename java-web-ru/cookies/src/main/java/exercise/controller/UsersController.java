package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) throws Exception {
        String token = Security.generateToken();
        ctx.cookie("secretToken", token);
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var encriptedPassword = ctx.formParam("encriptedPassword");
        //var userToken = ctx.formParamAsClass("token", String.class)

        var user = new User(firstName, lastName, email, encriptedPassword, token);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
        //ctx.render("users/build.jte");
    }

    public static void show(Context ctx) throws Exception {
        String secretToken = ctx.cookie("secretToken");

        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        if (!secretToken.equals(user.getToken())){
            ctx.redirect(NamedRoutes.buildUserPath());
        };

        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));

        //ctx.render("users/show.jte");
    }
    // END
}
