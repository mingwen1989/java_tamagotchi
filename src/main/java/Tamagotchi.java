public class Tamagotchi {

    private Integer mActivityLevel;
    private Integer mSleepLevel;
    private Integer mFoodLevel;
    private String mName;

  public Tamagotchi(String name) {
      mActivityLevel = 5;
      mSleepLevel = 5;
      mFoodLevel = 5;
      mName = name;
  }

  public Integer getFoodLevel() {
      return mFoodLevel;
  }
  public Integer getSleepLevel() {
      return mSleepLevel;
  }
  public Integer getActivityLevel() {
      return mActivityLevel;
  }

  public String getPetName() {
      return mName;
  }

  public Integer feed() {
      mFoodLevel += 1;
      return mFoodLevel;
  }
  public Integer starve() {
      mFoodLevel -= 1;
      return mFoodLevel;
  }

  public Integer play() {
      mActivityLevel += 1;
      return mActivityLevel;
  }

  public Integer clean() {
      mActivityLevel += 1;
      return mActivityLevel;
  }

  public Integer tuck() {
      mSleepLevel += 1;
      return mSleepLevel;
  }

  public Integer ignore() {
      mSleepLevel -= 1;
      return mSleepLevel;
  }

  // public boolean isHappy() {
  //     if (mActivityLevel + mSleepLevel + mFoodLevel > 20){
  //       return true;
  //     else {
  //       return false;
  //       }
  // }}
  //
  // public boolean isContent() {
  //     if (mActivityLevel + mSleepLevel + mFoodLevel > 15){
  //       return true;
  //     else {
  //       return false;
  //       }
  // }}
  //
  // public boolean isTired() {
  //     if (mActivityLevel + mSleepLevel + mFoodLevel > 10){
  //       return true;
  //     else {
  //       return false;
  //     }
  // }}
  //
  public boolean isAlive() {
      if (mActivityLevel + mSleepLevel + mFoodLevel > 5){
        return true;
      }
      else {
        return false;
      }
  }
}
