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

    public static String toString(Range[] rangeArrays) {
        StringBuilder sb = new StringBuilder();

        if (rangeArrays == null) {
            return null;
        }

        if (rangeArrays.length == 0) {
            return "[]";
        }

        if (rangeArrays.length == 1) {
            for (Range range : rangeArrays) {
                sb.append("[")
                        .append(range)
                        .append("]");
            }
        } else {
            sb.append("[").append(rangeArrays[0]).append(", ");

            for (int i = 1; i < rangeArrays.length; i++) {
                if (i < rangeArrays.length - 1) {
                    sb.append(rangeArrays[i]).append(", ");
                } else {
                    sb.append(rangeArrays[i]).append("]");
                }
            }
        }

        return sb.toString();
    }

    public Range getIntersection(Range range2) {
        if ((Math.min(this.from, range2.from) == this.from) && (Math.max(this.to, range2.to) == this.to)) {
            return new Range(range2.from, range2.to);
        }

        if ((Math.min(this.from, range2.from) == range2.from) && (Math.max(this.to, range2.to) == range2.to)) {
            return new Range(this.from, this.to);
        }

        if ((Math.min(this.to, range2.from) == range2.from) && (Math.min(this.from, range2.from) == this.from)) {
            return new Range(range2.from, this.to);
        }

        if ((Math.min(this.from, range2.to) == this.from) && (Math.min(this.from, range2.from) == range2.from)) {
            return new Range(this.from, range2.to);
        }

        return null;
    }

    public Range[] getUnion(Range range2) {
        if (this.to < range2.from || range2.to < this.from) {
            return new Range[]{new Range(this.from, this.to), new Range(range2.from, range2.to)};
        }

        if ((Math.min(this.from, range2.from) == this.from) && (Math.max(this.to, range2.to) == this.to)) {
            return new Range[]{new Range(this.from, this.to)};
        }

        if ((Math.min(this.from, range2.from) == range2.from) && (Math.max(this.to, range2.to) == range2.to)) {
            return new Range[]{new Range(range2.from, range2.to)};
        }

        if (this.from <= range2.from && this.to <= range2.to) {
            return new Range[]{new Range(this.from, range2.to)};
        }

        if (this.from >= range2.from && this.to >= range2.to) {
            return new Range[]{new Range(range2.from, this.to)};
        }

        return null;
    }

    public Range[] getDifference(Range range2) {
        if (this.from < range2.from && range2.from < range2.to && range2.to < this.to) {
            return new Range[]{new Range(this.from, range2.from), new Range(range2.to, this.to)};
        }

        if ((this.from < this.to && this.to <= range2.from && range2.from < range2.to) ||
                (range2.from < range2.to && range2.to <= this.from && this.from < this.to)) {
            return new Range[]{new Range(this.from, this.to)};
        }

        if (this.from < range2.from && range2.from < this.to && this.to < range2.to) {
            return new Range[]{new Range(this.from, range2.from)};
        }

        if (range2.from < this.from && this.from < range2.to && range2.to < this.to) {
            return new Range[]{new Range(range2.to, this.to)};
        }

        return new Range[]{};
    }
}