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

    public String toString(Range[] rangeArray) {
        StringBuilder sb = new StringBuilder();

        if (rangeArray == null) {
            return null;
        } else {
            for (Range range : rangeArray) {
                sb.append(range.toString());
            }
        }

        return sb.toString();
    }

    public Range getIntersectionInterval(Range range1, Range range2) {
        if (range1 == null || range2 == null) {
            return null;
        }

        if (range1.from < range2.from && range2.from < range1.to && range1.to < range2.to) {
            return new Range(range2.from, range1.to);
        }

        if (range2.from < range1.from && range1.from < range2.to && range2.to < range1.to) {
            return new Range(range1.from, range2.to);
        }

        if (range1.from < range2.from && range2.from < range2.to && range2.to < range1.to) {
            return new Range(range2.from, range2.to);
        }

        if (range2.from < range1.from && range1.from < range1.to && range1.to < range2.to) {
            return new Range(range1.from, range1.to);
        }

        return null;
    }

    public Range[] getUnionInterval(Range range1, Range range2) {
        if (range1 == null || range2 == null) {
            return null;
        }

        if (range1.from < range2.from && range2.from <= range1.to && range1.to < range2.to) {
            return new Range[]{new Range(range1.from, range2.to)};
        }

        if (range2.from < range1.from && range1.from <= range2.to && range2.to < range1.to) {
            return new Range[]{new Range(range2.from, range1.to)};
        }

        if (range1.from <= range2.from && range2.from <= range2.to && range2.to <= range1.to) {
            return new Range[]{new Range(range1.from, range1.to)};
        }

        if (range2.from <= range1.from && range1.from <= range1.to && range1.to <= range2.to) {
            return new Range[]{new Range(range2.from, range2.to)};
        }

        if ((range1.from <= range1.to && range1.to < range2.from && range2.from <= range2.to) ||
                (range2.from <= range2.to && range2.to < range1.from && range1.from <= range1.to)) {

            return new Range[]{range1, range2};
        }

        return null;
    }

    public Range[] getDifferenceInterval(Range range1, Range range2) {
        if (range1 == null || range2 == null) {
            return null;
        }

        if (range1.from < range2.from && range2.from < range2.to && range2.to < range1.to) {
            return new Range[]{new Range(range1.from, range2.from), new Range(range2.to, range1.to)};
        }

        if (range1.from < range1.to && range1.to < range2.from && range2.from < range2.to) {
            return new Range[]{range1};
        }

        if (range1.from < range2.from && range2.from < range1.to && range1.to < range2.to) {
            return new Range[]{new Range(range1.from, range2.from)};
        }

        if (range2.from < range1.from && range1.from < range2.to && range2.to < range1.to) {
            return new Range[]{new Range(range2.to, range1.to)};
        }

        return null;
    }
}