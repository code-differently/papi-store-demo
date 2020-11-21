//What package we are inside of.
package com.codedifferently.store;

//classes we are importing. This way we can use ArrayLists, HashMaps & Map.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Create a public/accessable class named Papistore.
// Add private variables which will be our "State" once we create an object from this class.
public class PapiStore {
    private boolean isStoreOpen;
    private ArrayList<String> tabs;
    //Create a Map which will hold a name and an amount owed.
    Map<String, Double> owesPapiMoney;

    //constructor function that sets up our "State" variables values.
    public PapiStore(){
        this.isStoreOpen = false; //initially set store to closed.
        this.tabs = new ArrayList(); // ArrayList of tabs
        this.owesPapiMoney = new HashMap<>(); // Map of who owes, and how much they owe.
    }

    //Second constructor function. This one we can pass in values - we can start the store as open.
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

    //tell us if the store is open.
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
    private boolean hasAnOverDueBalance(String name){
        if(!owesPapiMoney.containsKey(name))
            return false;
        Double money = owesPapiMoney.get(name);
        Boolean owes = false;
        if(money > 0.0)
            owes = true;
        return owes;
    }

    // A private method to tell us if this person has an active tab. Will return true or false.
    private boolean hasAnActiveTab(String name){
        for (String tab : tabs){
            if (tab.equals(name))
                return true;
        }
        return false;
    }

    //will create an active tab
    public void createActiveTab(String name){
        this.tabs.add(name);
    }

    // print out welcome message.
    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
