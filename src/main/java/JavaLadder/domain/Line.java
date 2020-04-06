package JavaLadder.domain;

import java.util.*;

public class Line {
    private List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        List line = generate(countOfPerson);
        this.line = line;
    }

    public Line(List<Boolean> list) {
        this.line = list;
    }

    private List generate(int countOfPerson) {
        List<Boolean> points = new ArrayList();
        for (int i = 0; i < countOfPerson - 1; i++) {
            checkSuccessTrue(line, i);
        }
        return line;
    }

    private void checkSuccessTrue(List<Boolean> line, int i) {
        if (i > 0 && line.get(i - 1)) {
            line.add(false);
            return;
        }
        line.add(new Random().nextBoolean());
        return;
    }

    @Override
    public String toString() {
        return line.toString();
    }

    public Boolean isLine(int i) {
        return this.line.get(i);
    }

    public int size() {
        return this.line.size();
    }

    public int countLine() {
        return (int) Arrays.asList(line).stream().filter(n -> true).count();
    }

    public void moveByLine(Point point) {
        if(point.getPoint() == 0){
            //오른쪽체크
            if(line.get(0)){
                point.RightMove();
            }
            return;
        }

        if(point.getPoint() == line.size()){
            if(line.get(line.size()-1)){
                point.leftMove();
            }
            return;
        }

        //양쪽체크
        if(line.get(point.getPoint()-1)){
            point.leftMove();
            return;
        }else if(line.get(point.getPoint())){
            point.RightMove();
            return;
        }
    }
}
