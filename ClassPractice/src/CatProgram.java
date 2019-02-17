import java.io.*;

public class CopyFile {

   public static void main(String args[]) throws IOException {
      FileReader in = null;
      FileWriter out = null;

      try {
         in = new FileReader("input.txt");
         out = new FileWriter("output.txt");

         int c; // Each char is read in as an int code
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      } finally {
         // Close input and output streams
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}
