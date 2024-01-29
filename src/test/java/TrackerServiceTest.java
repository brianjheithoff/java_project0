import org.example.Exception.TrackerException;
import org.example.Model.Tracker;
import org.example.Service.TrackerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TrackerServiceTest {

    TrackerService trackerService;

    /**
     * Before every single test, we should reset the recipe service to a
     * newly-instantiated object.
     */
    @Before
    public void setUp(){
        trackerService = new TrackerService();
    }

    /**
     * When the recipe service is first created, it should contain zero recipes.
     */
    @Test
    public void trackerServiceEmptyAtStart(){
        List<Tracker> trackerList = trackerService.getAllTracker();
//        ensure that at the start, there are no recipes
        Assert.assertTrue(trackerList.size() == 0);
    }
    /**
     * I want to test the "happy path"
     *  - adding one or multiple good recipes, everything works
     * I want to test erroneous behavior
     *  - adding misformatted recipes, expecting exceptions to be thrown
     * If I wanted to do a TDD example, I would write test cases for deleting a recipe
     * prior the implementation of deleteRecipe in recipeservice.
     */
    /**
     * Add a recipe
     * After getting all recipes, ensure that the recipe we added exists within
     * the list of recipes.
     * We could also ensure that the timestamp is accurate
     */
    /**
     * On adding a valid recipe, that recipe should be within the returned
     * list of recipes.
     */
    @Test
    public void trackerServiceAddRecipe(){
//        arrange
        String testName = "title";
        String testDetails = "instructions";
        int testDistance = 1;
//        act
        try {
            trackerService.addTracker(testName, testDetails, testDistance);
        }catch (TrackerException x){
//            if the recipeexception is thrown, that is incorrect behavior, fail the test
            x.printStackTrace();
            Assert.fail("recipe exception incorrectly thrown");
        }
//        assert
        List<Tracker> trackers = trackerService.getAllTracker();
//        I'm expecting a single recipe in the list - at index 0
        Tracker actual = trackers.get(0);
        Assert.assertEquals(testName, actual.getName());
        Assert.assertEquals(testDetails, actual.getDetails());
        Assert.assertEquals(testDistance, actual.getDistance());
    }
    /**
     * When an invalid recipe is added, a recipeexception should be thrown.
     */
    @Test
    public void addTrackerInvalidDistance(){
        String name = "title";
        String details = "instructions";
        int numDistance = -1;
        try{
            trackerService.addTracker(name, details, numDistance);
//            Because the recipeexception should have been thrown on the line
//            above, getting to this point of this test should be impossible,
//            so, fail the test.
            Assert.fail();
        }catch(TrackerException e){
//            it's expected that we should reach the catch block, because
//            RecipeException should have been thrown on account of having
//            negative servings.
        }
    }
}


