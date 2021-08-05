package projectzero.budgetar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GetDataTest {

    //will test the existence of a file
    @Test
    @DisplayName("Test for the existence of the file")
    void myFileExists() {
         File fileTest = new GetData().filepath.toFile();
        Assertions.assertTrue(fileTest.exists());

    }

    @Test
    @DisplayName("Test if the file is Read enabled")
    void myFileRead(){
        File fileTest = new GetData().filepath.toFile();
        Assertions.assertTrue(fileTest.canRead());

    }

    @Test
    @DisplayName("Test if the File is Write Enabled")
    void myFileWrite(){
        File fileTest = new GetData().filepath.toFile();
        Assertions.assertTrue(fileTest.canWrite());
    }

    @Test
    @DisplayName("Test if the Budget value is reset")
    void myBudget(){
        double amt = new GetData().tfa;
        Assertions.assertEquals(0, amt);
    }
}