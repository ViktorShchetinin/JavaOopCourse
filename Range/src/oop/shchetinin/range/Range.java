package oop.shchetinin.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
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

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
    }

    public static String toString(Range[] rangesArray) {
        if (rangesArray == null) {
            return "[]";
        } else if (rangesArray.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (Range range : rangesArray) {
            sb.append(range).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length()).append("]");

        return sb.toString();
    }

    public Range getIntersection(Range range) {
        if (to <= range.from || range.to <= from) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || range.to < from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    public Range[] getDifference(Range range) {
        if (from < range.from && range.to < to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if ((from < to && to <= range.from && range.from < range.to) ||
                (range.from < range.to && range.to <= from && from < to)) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && range.from < to && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        if (range.from <= from && from < range.to && range.to < to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{};
    }
}