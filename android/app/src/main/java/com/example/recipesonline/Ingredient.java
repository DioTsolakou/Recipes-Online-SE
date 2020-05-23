package com.example.recipesonline;

public class Ingredient {
    private String name;
    private int calories;

    /* Constructor */
    public Ingredient(String name) {
        this.name = name;
        this.calories = 0;
    }

    /* Constructor */
    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {return name;}
    public int getCalories() {return calories;}

    public void setName(String name) {this.name = name;}
    public void setCalories(int calories) {this.calories = calories;}

    /* Assume that if the name of the compared ingredients are the same, then they are the same ingredient*/
    @Override
    public boolean equals(Object i) {
        if(!(i instanceof Ingredient)) return false;
        return ((Ingredient)i).getName().equalsIgnoreCase(this.name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString () {
        String s = name;
        if (calories > 0) s += " (" + calories + " cal / 100 gr)";
        return s;
    }
}