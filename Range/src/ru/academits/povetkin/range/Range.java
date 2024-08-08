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

    public Range intersection(Range secondRange) {
        Range resultRange = new Range(0, 0);

        if (this.isInside(secondRange.from) && this.isInside(secondRange.to)) {
            resultRange.setFrom(secondRange.from);
            resultRange.setTo(secondRange.to);
            return resultRange;
        } else if (secondRange.isInside(this.from) && secondRange.isInside(this.to)) {
            resultRange.setFrom(this.from);
            resultRange.setTo(this.to);
            return resultRange;
        } else {
            return null;
        }
    }

    public Range[] consolidation(Range secondRange) {
        Range[] resultRange = {this,null};

        if (this.isInside(secondRange.from) && this.isInside(secondRange.to)) {
            resultRange[0].setFrom(this.from);
            resultRange[0].setTo(this.to);
            return resultRange;
        } else if (secondRange.isInside(this.from) && secondRange.isInside(this.to)) {
            resultRange[0].setFrom(secondRange.from);
            resultRange[0].setTo(secondRange.to);
            return resultRange;
        } else if (this.isInside(secondRange.from)) {
            resultRange[0].setFrom(this.from);
            resultRange[0].setTo(secondRange.to);
            return resultRange;
        } else if (this.isInside(secondRange.to)) {
            resultRange[0].setFrom(secondRange.from);
            resultRange[0].setTo(this.to);
            return resultRange;
        } else {
            resultRange[0] = this;
            resultRange[1] = secondRange;
            return resultRange;
        }
    }

    public Range[] difference(Range secondRange) {
        Range[] resultRange = {this,null};

        if (this.isInside(secondRange.from) && this.isInside(secondRange.to)) {
            resultRange[0].setFrom(this.from);
            resultRange[0].setTo(this.to - secondRange.getLength());
            return resultRange;
        } else if (secondRange.isInside(this.from) && secondRange.isInside(this.to)) {
            resultRange[0].setFrom(secondRange.from);
            resultRange[0].setTo(secondRange.to - this.getLength());
            return resultRange;
        } else {
            resultRange[0] = this;
            resultRange[1] = secondRange;
            return resultRange;
        }
    }
}
