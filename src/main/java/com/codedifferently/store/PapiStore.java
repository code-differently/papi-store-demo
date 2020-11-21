//What package we are inside of. Family relation of objects.
package com.codedifferently.store;

//classes we are importing. This way we can use ArrayLists, HashMaps & Map.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Create a public/accessable class named Papistore.
// Add private variables which will be our "State" once we create an object from this class or pass it a value.
public class PapiStore {
    private boolean isStoreOpen;
    private ArrayList<String> tabs;
    //Create a Map which will hold a name and an amount owed.
    //Hashmap is a type of Map. Map is the Interface.
    Map<String, Double> owesPapiMoney;

    //constructor function that sets up our "State" variables values.
    public PapiStore(){
        //this allows us to set the initial values - to give our variables values.
        //THIS refers to the object that will be created, and allows us to create a new instance of the object w/ unique values.
        this.isStoreOpen = false; //initially set store to closed.
        this.tabs = new ArrayList(); // ArrayList of tabs
        this.owesPapiMoney = new HashMap<>(); // Map of who owes, and how much they owe.
    }

    //Second constructor function. This one we can pass in values - we can start with the isStoreOpen variable set to true or false.
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        this.isStoreOpen = isOpen;
        this.tabs = tabsIn;
        this.owesPapiMoney = new HashMap<>();
    }

    // This will allow us to close the store.
    public void closeStore(){
    }

    //this will allow us to open the store, if its already open it wont change anything.
    public void openStore(){
        this.isStoreOpen = true;
    }

    //tell us the state of the store - if the store is open or closed.
    public boolean isStoreOpen() {
        return isStoreOpen;
    }

    //tell us if this person is allowed to have a tab. If they have an overdue balance it will return false. Else true.
    public Boolean allowToUseTab(String name){
        Boolean response = false;
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
            response = true;
        return response;
    }

    // A private method for us to check if our name has an overdue balance. Will return true or false.
    // This method takes in a String name variable.
    private boolean hasAnOverDueBalance(String name){
        //If this name as a key DOES NOT owe a value return false.
        if(!owesPapiMoney.containsKey(name))
            return false;
        Double money = owesPapiMoney.get(name);
        Boolean owes = false;
        //if there is a balance, or money owed is greater than 0 return true.
        if(money > 0.0)
            owes = true;
        return owes;
    }

    // A private method to tell us if this person has an active tab. Will return true or false.
    // This method takes in a String name variable.
    private boolean hasAnActiveTab(String name){
        //Enhanced for loop to go through each tab in tabs ArrayList.
        for (String tab : tabs){
            //if there is a match to the name - they have an active tab - return true.
            if (tab.equals(name))
                return true;
        }
        //If there is no match return false.
        return false;
    }

    //will create a new active tab by passing a name variable and adding it to our tabs ArrayList.
    public void createActiveTab(String name){
        this.tabs.add(name);
    }

    // This will print out a welcome message to the console when we run our program.
    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
