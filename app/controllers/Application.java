package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {



    public static Result contact() {
        return ok(contact.render("Your new application is ready."));
    }
    public static Result faq() {
        return ok(faq.render("Your new application is ready."));
    }

    public static Result shortcodes() {
        return ok(shortcodes.render("Your new application is ready."));
    }
    
    public static Result icons() {
        return ok(icons.render("Your new application is ready."));
    }

}
