import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaverUtils{
    @SaveTo(path = "/Users/demon/Downloads/file.txt")
    public static void save(Container container, String savepath){
        try {
            BufferedWriter output = new BufferedWriter(
                    new FileWriter(savepath));   //"/Users/demon/Downloads/file.txt"));
            output.write(container.text);
            output.close();
        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e);
        }catch (IOException e){
            System.out.println("IOException"+e);
        }
        System.out.println("File was written!");
    }
}
