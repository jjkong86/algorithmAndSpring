package etc.ladder;

import java.util.*;
import java.util.stream.Collectors;

public class LadderMaker {
    private int ladderColumn;
    private int ladderRow;
    private Ladder[][] targetPos;


    public LadderMaker(int column, int row) {
        ladderColumn = column;
        ladderRow = row;
        targetPos = new Ladder[ladderColumn][ladderRow];
    }


    public List<List<LadderVo>> getResultPath() {
        this.resetNextPosMap();
        this.makeNewGameMap();

        List<List<LadderVo>> LadderVoList = new ArrayList<>();
        for (int x = 0; x < targetPos.length; x++) {
            List<LadderVo> columnList = new ArrayList<>();
            for (int y = 0; y < targetPos[x].length; y++) {
                LadderVo result = new LadderVo();
                result.setX(x);
                result.setY(y);
                result.setPoint(targetPos[x][y]);
                columnList.add(result);
            }

            LadderVoList.add(columnList);
        }

        return LadderVoList;
    }

    //초기화 함수 :  모든 기본점은 아래로 이어짐.
    private void resetNextPosMap() {
        for (int x = 0; x < this.ladderColumn; x++) {
            for (int y = 0; y < this.ladderRow; y++) {
                int nextY = Math.min(y + 1, this.ladderRow - 1);
                targetPos[x][y] = new Ladder(x, nextY);
            }
        }
    }

    /**
     * 메인 로직 :  패쓰를 만듬 로직
     * 1. 현재 라인에 선이 있으면 건너 뛰움
     * 2. 포인트 이동 로직
     * 3. y좌표 상중하
     * 4. 최대 확률내에 랜덤 확률 연
     */
    private void makeNewGameMap() {
        for (int x = 0; x < this.ladderColumn - 1; x++) {
            for (int y = 1; y < this.ladderRow - 2; y++) {

                // 이미 선이 그어진 포인트 제외
                if (x != targetPos[x][y].getX()) {
                    continue;
                }
                // 현재 포인트를 선택할지 같은 라인의 다음 포인트를 선택할지 확률로 결정
                y = this.getConFirmPointCurrentOrNextY(x, y);
                // 타겟 포인트의 y좌표 선택 확률: 상 : 중: 하 = 20 : 35 : 45
                Map<Ladder, Integer> targetData = this.getMapSelectYCoordinateAfterPut(x, y);
                // 최대 확률 내에서 랜덤 확률 연산
                y = this.getNextYAfterResultPut(targetData, x, y);
            }
        }

    }

    /**
     * 2. 현재 포인트를 선택할지 같은 X좌표의 다음 Y좌표를 선택할지 확률로 결정
     * 2-1. 현재 라인에 선이 있으면 건너 뛰움
     * 2-2. 랜덤으로 40퍼 이내에 로직일 경우 y값 증가
     */
    private int getConFirmPointCurrentOrNextY(int x, int y) {
        if (y + 1 >= this.ladderRow - 1) return y;
        for (int yNext = y + 1; yNext < this.ladderRow - 1; yNext++) {
            // 이미 선이 그어진 포인트 제외
            if (x != targetPos[x][yNext].getX()) {
                continue;
            }
            // 선택 확률: 첫 번째 포인트 : 두 번째 포인트 = 60 : 40
            if (new Random().nextInt(100) >= 40) {
                break;
            }
            y = yNext;
            break;
        }
        return y;
    }

    // 타겟 포인트의 y좌표 선택 확률: 상 : 중: 하 = 20 : 35 : 45
    private Map<Ladder, Integer> getMapSelectYCoordinateAfterPut(int x, int y) {
        Map<Ladder, Integer> targetData = new LinkedHashMap<>();
        // 타겟 포인트의 y좌표 선택 확률: 상 : 중: 하 = 20 : 35 : 45
        int[] selectPercent = {20, (20 + 35), (20 + 35 + 45)};
        //dy는 하 중 상 오른쪽아래 칸,오른쪽,오른쪽 위
        for (int dy = 1; dy >= -1; dy--) {
            int nextX = x + 1;
            //int y + dy
            // 각 라인의 첫 포인트, 마지막 포인트 선택 제외
            if (y + dy == 0 || y + dy >= this.ladderRow - 1) {
                continue;
            }

            // 이미 선이 그어진 포인트 제외
            if (nextX != targetPos[nextX][y + dy].getX()) {
                break;
            }
            // 최대 3개의 타겟 포인트와 확률 저장
            targetData.put(new Ladder(nextX, y + dy), selectPercent[dy + 1]);
        }
        return targetData;
    }

    private int getNextYAfterResultPut(Map<Ladder, Integer> targetData, int x, int y) {
        if (targetData.size() <= 0) return y;

        int maxValue = targetData.values().stream().mapToInt(integer -> integer).max().orElse(0); //맥스값 추출
        // 최대 확률 내에서 랜덤 확률 연산
        int selPercent = new Random().nextInt(maxValue);
        targetData = targetData.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<Ladder, Integer> itr : targetData.entrySet()) {
            Ladder coordinate = itr.getKey(); //좌표의
            int percent = itr.getValue();
            // 포인트 확률이 랜덤 확률내에 포함되면, 타겟 포지션 선택
            if (percent >= selPercent) {
                // 사다리의 시작 포인트와 종료 포인트, 두 포인트의 타겟 포인트 저장
                targetPos[x][y] = coordinate;
                targetPos[coordinate.getX()][coordinate.getY()] = new Ladder(x, y);

                // 특정 확률로 시작 포인트 y좌표를 아래로 한 칸 옮기기: 90%
                if (new Random().nextInt(100) < 90 && y + 1 < this.ladderRow - 1) {
                    y++;
                }
                break;
            }
        }
        return y;
    }

    public static void main(String[] args) {
        LadderMaker ladderMaker = new LadderMaker(6, 10);
        List<List<LadderVo>> list = ladderMaker.getResultPath();
        StringJoiner sj = new StringJoiner("----");
        String BLANK = "            ";
        sj.add("");

        int ho = list.get(0).size();
        for (int i = 0; i < ho; i++) {
            sj.add(String.valueOf(i));
            for (List<LadderVo> LadderVos : list) {
                LadderVo temp = LadderVos.get(i);
                String result = BLANK;
                if (temp.getX() != temp.getPoint().getX()) {
                    result = "x : " + temp.getPoint().getX() + ", y : " + temp.getPoint().getY();
                }

                sj.add(result);
            }
            sj.add("\n");
        }
        System.out.println(sj.toString());

    }
}
