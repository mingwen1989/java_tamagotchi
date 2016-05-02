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
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/pet", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String nameInput = request.queryParams("name");
      request.session().attribute("name", nameInput);
      model.put("name", nameInput);
      model.put("template", "templates/pet.vtl");

      request.session().attribute("nameInput", nameInput);
      model.put("nameInput", nameInput);

      //action  will either be feed or sleep or? .equals()
      if (request.session().attribute("newTamagotchi") != null) {
        Tamagotchi newTamagotchi = request.session().attribute("newTamagotchi");
        String action = request.queryParams("action");

      if (action != null ) {
        if (action.equals("feed")){
          newTamagotchi.feed();
        } else if (action.equals("starve")) {
          newTamagotchi.starve();
        } else if (action.equals("play")) {
          newTamagotchi.play();
        } else if (action.equals("clean")) {
          newTamagotchi.clean();
        } else if (action.equals("tuck")) {
          newTamagotchi.tuck();
        } else if (action.equals("ignore")) {
          newTamagotchi.ignore();
        }
      }
      model.put("newTamagotchi", newTamagotchi);

      String tamagotchiStatus = newTamagotchi.status();
      model.put("tamagotchiStatus", tamagotchiStatus);
    } else {
        String name = request.queryParams("name");
        String status = request.queryParams("status");
        Tamagotchi newTamagotchi = new Tamagotchi(name, status);
        request.session().attribute("newTamagotchi", newTamagotchi);
        model.put("newTamagotchi", newTamagotchi);

        String tamagotchiStatus = newTamagotchi.status();
        model.put("tamagotchiStatus", tamagotchiStatus);
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/home", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/home.vtl");
    //   model.put("nameInput", request.session().attribute("nameInput"));
    //   Tamagotchi newTamagotchi = new Tamagotchi("Dragon", "happy");
    //
    //   String tamagotchiStatus = newTamagotchi.status();
    //   model.put("tamagotchiStatus", tamagotchiStatus);
    //
    //   String foodLevel = Integer.toString(newTamagotchi.getFoodLevel());
    //   String sleepLevel = Integer.toString(newTamagotchi.getSleepLevel());
    //   String activityLevel = Integer.toString(newTamagotchi.getActivityLevel());
    //   model.put("foodLevel", foodLevel);
    //   model.put("sleepLevel", sleepLevel);
    //   model.put("activityLevel", activityLevel);
    //
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }

}
