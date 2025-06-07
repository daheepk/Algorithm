import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

class Main {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.print(sdf.format(date));
    }
}