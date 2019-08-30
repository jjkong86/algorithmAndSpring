package reetCodeAlgorithms.Dungeon_Game;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static boolean[][] isRun;
	static int[][] minHealth;
	static int[][] sDungeon;
	static int xLen;
	static int yLen;
    public class Coordinates {
        int x;
        int y;
        Coordinates(int x, int y) {
        	this.x = x;
        	this.y = y;
        }
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        // 목표지점까지 최소의 체력으로 갈 수 있는 루트를 찾는 문제
        // 오른쪽, 아래로만 이동 가능
        // 큐 이용하면 될듯??
    	sDungeon = dungeon;
        Queue<Coordinates> q = new LinkedList<>();
        q.add(new Coordinates(0, 0));
        minHealth = new int[dungeon.length][dungeon[0].length];
        isRun = new boolean[dungeon.length][dungeon[0].length];
        minHealth[0][0] = dungeon[0][0];
        isRun[0][0] = true;
        while (!q.isEmpty()) {
        	Coordinates c = q.poll();
        	Coordinates xPlus = new Coordinates(c.x+1, c.y);
        	makeHealth(c, xPlus);
        	
        	Coordinates yPlus = new Coordinates(c.x, c.y+1);
        	makeHealth(c, yPlus);
        	
        	addAndCheck(xPlus);
        }
        
        
        return 0;
    }

	private void makeHealth(Coordinates c, Coordinates next) {
    	if (!isRun[next.x][next.y]) {
    		isRun[next.x][next.y] = true;
    		minHealth[next.x][next.y] = sDungeon[next.x][next.y] + minHealth[c.x][c.y];
    	} else {
    		minHealth[next.x][next.y] = Math.max(minHealth[next.x][next.y], sDungeon[next.x][next.y] + minHealth[c.x][c.y]);
    	}
    }
	
	private void addAndCheck(Coordinates xPlus) {
		
		
	}
}
