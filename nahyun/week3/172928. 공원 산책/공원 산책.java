import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int rows = park.length;
        int cols = park[0].length();
        String[][] newPark = new String[rows][cols];
        int[] start = new int[2];
        for(int i = 0; i < rows; i++) {
            String[] str = park[i].split("");
            //첫 시작점 찾기
            int index = Arrays.asList(str).indexOf("S");
            if(index > -1) {
                start[0] = i; start[1] = index;
            }
            newPark[i] = str;
        }
        
        //cf) "E 2" 이런식으로 주어짐
        for(int i = 0; i<routes.length; i++) {
            String[] st = routes[i].split(" ");
            String op = st[0]; int n = Integer.parseInt(st[1]);
            boolean checkAll = checkFunc(op, n, newPark, start[0], start[1], rows, cols);
            if(checkAll) {
                switch (op){
                    case "E":
                        start[1] += n; break;
                    case "N":
                        start[0] -= n; break;
                    case "S":
                        start[0] += n; break;
                    case "W" :
                        start[1] -= n; break;
                }
            }
        }
        
        return start;
    }
    
    public static boolean checkFunc(String op, int n, String[][] park, int x, int y, int rows, int cols) {
        for(int i = 0; i<n; i++) {
            switch (op) {
                case "E":
                    y++; break;
                case "W":
                    y--; break;
                case "S":
                    x++; break;
                case "N":
                    x--; break;
            }
            if(x<0 || x>=rows || y<0 || y>=cols) return false;
            else if(park[x][y].equals("X")) return false;
        }
        return true;
    }
}
