// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the Assert Class from the org.junit package or folder
import org.junit.Assert;
// This imports the Before class for our @Before from the org.junit package or folder
import org.junit.Before;
// This imports our Test class for @Test from the org.junit package or folder
import org.junit.Test;

// This is a public class, PapiStoreTest set up so that we can test all of the methods in our PapiStore Class.
    public class PapiStoreTest {

        // creates a variable to store our object in - outside of the scope of the methods so that all of our @Test methods have access.
        // the "ID" of our object.
        PapiStore papiStore;

        //fixture annotation -
        // creates a new object and stores it in the papistore variable.
        // the method sets up our state by assigning values.
        @Before
        public void setup(){
            //new object being created for testing.
            papiStore = new PapiStore();
            //Creating a new active tab for Jamal & Victor.
            papiStore.createActiveTab("Jamal");
            papiStore.createActiveTab("Victor");
            //Adding a value to our HashMap with the Key or Name and Value as a Double.
            papiStore.owesPapiMoney.put("Jamal", 0.0);
            papiStore.owesPapiMoney.put("Victor", 7.0);
        }

        //Test fixture annotation runs the open store test.
        //Asks if we open the store if its state changes to open!
        @Test
        public void OpenStoreTest(){
            //Given
            papiStore.openStore();

            //When
            //We expect this test to return true when we run the isStoreOpen();
            Boolean expected = true;
            Boolean actual = papiStore.isStoreOpen();

            //Then
            //Assert.assertEquals(expected, actual);
            //Assert that the method returns true when we run it.
            Assert.assertTrue(actual);
        }

        @Test
        public void allowToUseTabTestSuccess(){
            // given
            // when
            //We expect this test to return true when we run allowToUseTab() and pass in Jamal as an argument;
            Boolean expected = true;
            Boolean actual = papiStore.allowToUseTab("Jamal");

            // then
            //Assert that the method returns true when we run it.
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void allowToUseTabTestFail(){
            // given
            // when
            //We expect this test to return false when we run allowToUseTab() and pass in Victor as an argument;
            Boolean expected = false;
            Boolean actual = papiStore.allowToUseTab("Victor");

            //Assert that the method returns false when we run it.
            Assert.assertEquals(expected, actual);
        }
}
