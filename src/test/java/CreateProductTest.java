import org.testng.annotations.Test;
import org.testng.Assert;

public class CreateProductTest {

    @Test
    public void TestMethod(){
        System.out.println("Test Method output");
        Assert.assertTrue(true,"OK");
    }

    /**
     * Method to create new product
     * @param login
     * @param password
     */

//    @Test
    public void createNewProduct(String login, String password) {
System.out.println("createNewProduct");
        // TODO implement test for product creation

        // actions.login(login, password);
        // ...


    }

    /**
     * Method to check new product was created
     * @param login
     * @param password
     */
//    @Test(dependsOnMethods = {"createNewProduct"})
    public void checkNewProductCreated (String login, String password) {
        System.out.println("checkNewProductCreated");
        // TODO implement logic to check product visibility on website
    }

}

