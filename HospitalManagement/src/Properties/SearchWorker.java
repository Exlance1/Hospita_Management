package Properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchWorker
{
    //Yenileme işlemi için çalışanların listesini bulunduruyor. Burada stack ile txt dosyasından alıp UI'da karşımıza çıkmasını sağlamaktadır.
    public String workers()
    {
        String text = "";
        int counter = 0;

        try
        {
            FileReader reader = new FileReader("Workers.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while((line = bufferedReader.readLine()) != null)
            {
                counter++;
            }

            reader.close();

            Stack stack = new Stack(counter);

            FileReader reader1 = new FileReader("Workers.txt");
            BufferedReader bufferedReader1 = new BufferedReader(reader1);
            String line1;

            while((line1 = bufferedReader1.readLine()) != null)
            {
                stack.push(line1);
                text += stack.pop() + "\n";
            }

            reader1.close();
        }

        catch(IOException exception)
        {
            exception.printStackTrace();
        }

        return text;
    }
}