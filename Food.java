public enum FoodCategory {
    MAIN, DESSERT, DRINK;
}

public Class Food{
    /** Food name */
    public String name;
    /** Food category from MAIN, DESSERT, DRINK */
    public FoodCategory category;
    /** Tbd */
    private ArrayList <String> ingredients;
    /** boolean isVegan */
    private Boolean isVegan;
    /** boolean isVegetarian */
    private Boolean isVegetarian;
    /** boolean isSpicy */
    private Boolean isSpicy;
    /** boolean hasGluten */
    private Boolean hasGluten;
    /** boolean hasLacose */
    private Boolean hasLactose;
    /** boolean double price */
    public Double Price;

    // ADD INGREDIENT
    /**
     * constructor
     * @param string name
     * @param food category from FoodCategory
     * @param boolean isVegan, isVegetarian, isSpicy, hasGluten, hasLactose
     * @param double price
     */
    public Food(String name, FoodCategory category, boolean isVegan, boolean isVegetarian,
    boolean isSpicy, boolean hasGluten, boolean hasLactose, double price){
        this.name = name;
        this.category = category;
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
        this.isSpicy = isSpicy;
        this.hasGluten = hasGluten;
        this.hasLactose = hasLactose;
        this.price = price;
    }
     /** accessor for category */
    public void getCategory(){
        return this.category;
    }
     /** accessor for ingredients */
    public void getIngredients(){
        for (String s: this.ingredients){ //for p in the arraylist
            System.out.println("- " + s);
        }
    }
     /**
     * accessor for whether it is vegan
     * @return boolean isVegan
     */
    public void getIsVegan(){
        return this.isVegan;
    }
     /**
     * accessor for whether is is vegetarian
     * @return boolean isVegetarian
     */
    public void getIsVegetarian(){
        return this.isVegetarian;
    }
     /**
     * accessor for whether is is spciy
     * @return boolean isSpicy
     */
    public void getIsSpicy(){
        return this.isSpicy;
    }
      /**
     * accessor for whether it has gluten
     * @return boolean hasGluten
     */
    public void getHasGluten(){
        return this.hasGluten;
    }
     /**
     * accessor for whether it has lactose
     * @return boolean hasGluten
     */
    public void getHasLactose(){
        return this.hasLactose;
    }
     /**
     * accessor for price
     * @return double price
     */
    public void getPrice(){
        return this.price;
    }
}
