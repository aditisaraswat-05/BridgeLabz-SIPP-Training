package Java_Generics;

// MealPlan interface
interface MealPlan {
    String getMealType();

    String getItems();
}

// Vegetarian meal
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public String getItems() {
        return "Paneer, Rice, Vegetables";
    }
}

// Vegan meal
class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public String getItems() {
        return "Tofu, Quinoa, Salad";
    }
}

// Keto meal
class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public String getItems() {
        return "Chicken, Eggs, Cheese";
    }
}

// High-Protein meal
class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String getItems() {
        return "Protein Shake, Lentils, Eggs";
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public void showMealPlan() {
        System.out.println("Meal Type: " + meal.getMealType());
        System.out.println("Items: " + meal.getItems());
    }
}

// Utility class with generic method
class MealPlanner {
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        System.out.println("Generating your personalized meal plan...");
        meal.showMealPlan();
        System.out.println("Plan generated successfully!\n");
    }
}

// Main class
public class MealPlanApp {
    public static void main(String[] args) {
        Meal<VegetarianMeal> veg = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> protein = new Meal<>(new HighProteinMeal());

        MealPlanner.generatePlan(veg);
        MealPlanner.generatePlan(vegan);
        MealPlanner.generatePlan(keto);
        MealPlanner.generatePlan(protein);
    }
}

// 4. Personalized Meal Plan Generator
// Concepts: Generic Methods, Type Parameters, Bounded Type Parameters
// Problem Statement:
// Design a Personalized Meal Plan Generator where users can choose different
// meal categories like Vegetarian, Vegan, Keto, or High-Protein. The system
// should ensure only valid meal plans are generated.
// Hints:
// Define an interface MealPlan with subtypes (VegetarianMeal, VeganMeal, etc.).
// Implement a generic class Meal<T extends MealPlan> to handle different meal
// plans.
// Use a generic method to validate and generate a personalized meal plan
// dynamically.
