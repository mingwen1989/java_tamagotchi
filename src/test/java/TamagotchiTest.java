import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
public void tamagotchi_instantiatesCorrectly() {
  Tamagotchi myPet = new Tamagotchi("Dragon");
  assertEquals("Dragon", myPet.getPetName());
  assertEquals((Integer) 5, myPet.getActivityLevel());
  assertEquals((Integer) 5, myPet.getSleepLevel());
  assertEquals((Integer) 5, myPet.getFoodLevel());
 }

 @Test
 public void timePasses_foodDecreasesByOne_9() {
   Tamagotchi myPet = new Tamagotchi("Dragon");
   myPet.feed();
   myPet.feed();
   myPet.feed();
   myPet.feed();
   assertEquals((Integer) 9, myPet.getFoodLevel());
 }

 @Test
 public void isAlive_foodLevelAbove0_true() {
   Tamagotchi myPet = new Tamagotchi("Dragon");
   assertEquals(true, myPet.isAlive());
 }

  @Test
  public void isAlive_foodBelow1_false() {
  Tamagotchi myPet = new Tamagotchi("lil dragon");
  myPet.starve();
  myPet.starve();
  myPet.starve();
  myPet.starve();
  myPet.starve(); // make a method that will change the food level of your Tamagotchi
  myPet.starve();
  myPet.starve();
  myPet.starve();
  myPet.starve();
  myPet.starve();
  myPet.starve();
  assertEquals(false, myPet.isAlive());
}
}
