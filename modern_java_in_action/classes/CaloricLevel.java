package classes;

public enum CaloricLevel {
  DIET,
  NORMAL,
  FAT;

  public static CaloricLevel getCaloricLevel(Dish dish) {
    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
    else return CaloricLevel.FAT;
  }

}
