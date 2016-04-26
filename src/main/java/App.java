import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      Tamagotchi myPet = new Tamagotchi("Dragon", "happy");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/pet", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String name = request.queryParams("nameInput");
      request.session().attribute("nameInput", name);
      model.put("nameInput", request.session().attribute("nameInput"));
      model.put("template", "templates/pet.vtl");
      Tamagotchi myPet = new Tamagotchi("Dragon", "happy");

      //action  will either be feed or sleep or? .equals()
      String action = request.queryParams("action");

      if (action != null ) {
        if (action.equals("feed")){
          myPet.feed();
        } else if (action.equals("starve")) {
          myPet.starve();
        } else if (action.equals("play")) {
          myPet.play();
        }
      }



      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      model.put("nameInput", request.session().attribute("nameInput"));
      Tamagotchi myPet = new Tamagotchi("Dragon", "happy");

      String tamagotchiStatus = myPet.status();
      model.put("tamagotchiStatus", tamagotchiStatus);

      String foodLevel = Integer.toString(myPet.getFoodLevel());
      String sleepLevel = Integer.toString(myPet.getSleepLevel());
      String activityLevel = Integer.toString(myPet.getActivityLevel());
      model.put("foodLevel", foodLevel);
      model.put("sleepLevel", sleepLevel);
      model.put("activityLevel", activityLevel);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
