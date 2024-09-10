package ru.academits.povetkin.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "from = " + getFrom() + ", to = " + getTo();
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

    public Range getIntersection(Range range) {
        if (from <= range.from && to >= range.to) {
            return new Range(range.from, range.to);
        }

        if (from >= range.from && to <= range.to) {
            return new Range(from, to);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        if (range.to < from) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        if (range.to > from && range.from < from && range.to < to) {
            return new Range[]{new Range(range.from, to)};
        }

        if (to > range.from && from < range.from && to < range.to) {
            return new Range[]{new Range(from, range.to)};
        }

        return new Range[]{new Range(Math.min(range.from, from), Math.max(range.to, to))};
    }

    public Range[] getDifference(Range range) {
        if (to < range.from || to > range.from && from < range.from && to < range.to) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        if (range.to < from || range.to > from && range.from < from && range.to < to) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        if (getLength() == range.getLength()) {
            return null;
        }

        return new Range[]{new Range(from, to - range.getLength())};
    }
}