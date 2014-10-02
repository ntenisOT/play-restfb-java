package controllers;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.authUser;
import views.html.index;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result authUser(String accessToken) {
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
        User user = facebookClient.fetchObject("me", User.class);


        return ok(authUser.render(user.getFirstName() + " " + user.getLastName(), user.getEmail()));
    }

}
