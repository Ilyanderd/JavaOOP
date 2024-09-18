package ru.academits.povetkin.range;

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

    public Range getIntersection(Range range) {
        double resultFrom = Math.max(from, range.from);
        double resultTo = Math.min(to, range.to);

        if (resultFrom == range.from && resultTo == range.to) {
            return new Range(resultFrom, resultTo);
        }

        if (resultFrom == from && resultTo == to) {
            return new Range(resultFrom, resultTo);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        double resultFrom = Math.min(from, range.from);
        double resultTo = Math.max(to, range.to);

        if (to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        if (range.to < from) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        return new Range[]{new Range(resultFrom, resultTo)};
    }

    public Range[] getDifference(Range range) {
        if (to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        if (range.to < from) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        if (range.from > from && range.to < to) {
            return new Range[]{new Range(from + (range.getLength()/2), to - (range.getLength())/2)};
        }

        return new Range[0];
    }
}