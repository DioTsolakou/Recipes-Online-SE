package com.example.recipesonline;

class Ingredient {

    private String name;
    private int calories;

    Ingredient(String name) {
        this.name = name;
        this.calories = 0;
    }

    Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    String getName() {return name;}
    int getCalories() {return calories;}

    void setName(String name) {this.name = name;}
    void setCalories(int calories) {this.calories = calories;}

    @Override
    public boolean equals(Object i){
        if(!(i instanceof Ingredient)) return false;
        return ( ( ((Ingredient)i).getName().equalsIgnoreCase(this.name) ) &&
                ( (Ingredient)i).getCalories() == this.calories );
    }

    @Override
    public int hashCode(){
        return name.hashCode() * new Integer(calories).hashCode();
    }

}