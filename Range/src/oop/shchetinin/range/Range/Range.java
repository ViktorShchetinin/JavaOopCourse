package oop.shchetinin.range.Range;

public class Range {
    private String name;
    private double from;
    private double to;

    public Range(String name, double from, double to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public void print() {
        System.out.println(this.name);
        System.out.println("От: " + from);
        System.out.println("До: " + to);
    }
}