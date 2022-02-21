package oop.shchetinin.csv;

public class Csv {
    public static String CsvToHtml(String string) {
        StringBuilder sb = new StringBuilder();

        sb.append("<tr><td>");

        int a = 0;

        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) == ',') && string.charAt(i + 1) == '"') {
                sb.append("</td><td>");
                a = 1;

                continue;
            }

            if ((string.charAt(i) == ',') && string.charAt(i - 1) == '"') {
                sb.replace(0, 8, "")
                        .replace(i - 1, i, "")
                        .append("</td><td>");

                continue;
            }
            
            if (string.charAt(i) == ',') {
                sb.append("</td><td>");

                continue;
            }

            sb.append(string.charAt(i));
        }

        if (a == 0) {
            sb.append("</td></tr>");
        } else {
            sb.append("<br/>");
        }

        return sb.toString();
    }
}
