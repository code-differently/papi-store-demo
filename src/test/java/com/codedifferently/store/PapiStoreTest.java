// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the Assert Class from the org.junit package or folder
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// This is a public class called Papi
    public class PapiStoreTest {

        // create a variable to store our object in - outside of the scope of the methods.
        // the "ID" of our object.
        PapiStore papiStore;

        //fixture annotation -
        // creates a new object and stores it in the papistore variable.
        // the method sets up our state by assigning values.
        @Before
        public void setup(){
            papiStore = new PapiStore();
            papiStore.createActiveTab("Jamal");
            papiStore.createActiveTab("Victor");
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
            Boolean expected = true;
            Boolean actual = papiStore.isStoreOpen();

            //Then
            //Assert.assertEquals(expected, actual);
            Assert.assertTrue(actual);
        }

        @Test
        public void allowToUseTabTestSuccess(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            Boolean expected = true;
            Boolean actual = papiStore.allowToUseTab("Jamal");

            // then
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void allowToUseTabTestFail(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            Boolean expected = false;
            Boolean actual = papiStore.allowToUseTab("Victor");

            // then
            Assert.assertEquals(expected, actual);
        }
}
