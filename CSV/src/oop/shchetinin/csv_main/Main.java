package oop.shchetinin.csv_main;

import oop.shchetinin.csv.Csv;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("csv.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("output.txt", false))) {

            writer.println("<table>");

            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();

                writer.println(Csv.CsvToHtml(string));
            }

            writer.print("</table>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
