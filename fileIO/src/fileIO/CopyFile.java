package fileIO;

import java.io.*;
public class CopyFile {

   public static void main(String args[]) throws IOException {
      BufferedReader in = null;
      BufferedWriter out = null;

      try {
         in = new BufferedReader(new FileReader("input.txt"));
         out = new BufferedWriter(new FileWriter("output.txt"));

         String line;
         while ((line = in.readLine()) != null) {
            out.write(line );
            out.newLine(); // Writes a carriage return
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