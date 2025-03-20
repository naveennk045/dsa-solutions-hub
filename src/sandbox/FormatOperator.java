package sandbox;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatOperator {
    public static void main(String[] args) {
        System.out.printf("My name is %s and i am software developer%n","naveenkumar");
        System.out.printf("My name is %S and i am software developer%n","naveenkumar");
        System.out.printf("%C for Apple%n",'a');
        System.out.printf("Prime number %b%n",true);
        System.out.printf("%.2f%n",3.0000);
        System.out.printf("I am %d years %d months old%n",20,5);
        System.out.printf("I am %o years %d months old%n",20,5);
        System.out.printf("I am %x years %d months old%n",20,5);
        SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yy");
        Date birthDate=new Date();
        try {
            birthDate=sdf.parse("27:07:2004");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("On %s is my BirthDay%n", sdf.format(birthDate));

        // Number Formatting
        double num = 123456.789;
        System.out.printf("Floating-point (2 decimal): %.2f%n", num);
        System.out.printf("Scientific notation: %e%n", num);
        System.out.printf("General format: %g%n", num);
        System.out.printf("Thousands separator: %,f%n", num);

        double percentage = 0.1234;
        System.out.printf("Percentage: %.2f%%%n", percentage * 100);

        // Integer Formatting
        int numInt = 255;
        System.out.printf("Decimal: %d%n", numInt);
        System.out.println("Binary: " + Integer.toBinaryString(numInt));
        System.out.printf("Octal: %o%n", numInt);
        System.out.printf("Hexadecimal (lower): %x%n", numInt);
        System.out.printf("Hexadecimal (upper): %X%n", numInt);

        // String Formatting
        String str = "Java";
        System.out.printf("Left-aligned: %-10s%n", str);
        System.out.printf("Right-aligned: %10s%n", str);
        int width = 10;
        int leftPadding = (width - str.length()) / 2;
        int rightPadding = width - leftPadding - str.length();
        System.out.println("Center-aligned: " + " ".repeat(leftPadding) + str + " ".repeat(rightPadding));

        // Date and Time Formatting
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Date (YYYY-MM-DD): " + today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("Time (HH:MM:SS): " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}