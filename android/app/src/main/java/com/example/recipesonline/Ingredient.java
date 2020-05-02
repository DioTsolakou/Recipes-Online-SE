package com.example.recipesonline;

class Ingredient {

    private String name;
    private int calories;

    /* Constructor */
    Ingredient(String name) {
        this.name = name;
        this.calories = 0;
    }
    /* Constructor */
    Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    String getName() {return name;}
    int getCalories() {return calories;}

    void setName(String name) {this.name = name;}
    void setCalories(int calories) {this.calories = calories;}

    /* Assume that if the name and the calories of the ingredients compared are the same the ingredients are the same*/
    @Override
    public boolean equals(Object i) {
        if(!(i instanceof Ingredient)) return false;
        return ( (Ingredient)i).getName().equalsIgnoreCase(this.name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

}