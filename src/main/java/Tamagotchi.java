public class Tamagotchi {

    private Integer mActivityLevel;
    private Integer mSleepLevel;
    private Integer mFoodLevel;
    private String mName;
    private String mStatus;

  public Tamagotchi(String name, String status) {
      mActivityLevel = 5;
      mSleepLevel = 5;
      mFoodLevel = 5;
      mName = name;
      mStatus = status;
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

  public String status() {
      if ((mActivityLevel + mSleepLevel + mFoodLevel) >= 20){
        mStatus = "Happy";
      }
      if ((mActivityLevel + mSleepLevel + mFoodLevel) >= 15) {
        mStatus = "Content";
      }
      if ((mActivityLevel + mSleepLevel + mFoodLevel) >= 10){
        mStatus = "Tired";
      }
      if ((mActivityLevel + mSleepLevel + mFoodLevel) >= 0) {
        mStatus = "Zero";
      }
      return mStatus;
  }

  public boolean isAlive() {
      if (mActivityLevel + mSleepLevel + mFoodLevel > 5){
        return true;
      }
      else {
        return false;
      }
  }
}
