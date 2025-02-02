import java.util.*;

class 공원산 {
    public int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;
        int parkHeight = park.length;
        int parkWidth = park[0].length();

        for (int i = 0; i < parkHeight; i++) {
            for (int j = 0; j < parkWidth; j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        int x = startX;
        int y = startY;

        for (String route : routes) { // 경로에 따라 이동함
            char direction = route.charAt(0); // 이동 방향
            int steps = Integer.parseInt(route.substring(2));

            int newX = x;
            int newY = y;

            // 경로에 있는 각 칸을 하나씩 이동시킴
            boolean validMove = true;
            for (int i = 1; i <= steps; i++) {
                switch (direction) {
                    case 'N':
                        newX--;
                        break;
                    case 'S':
                        newX++;
                        break;
                    case 'W':
                        newY--;
                        break;
                    case 'E':
                        newY++;
                        break;
                }

                // 새 위치가 공원을 벗어나거나 장애물에 부딪히면 유효하지 않다
                if (newX < 0 || newX >= parkHeight || newY < 0 || newY >= parkWidth || park[newX].charAt(newY) == 'X') {
                    validMove = false;
                    break;
                }
            }

            // 경로가 유효하면 새로운 위치로 이동
            if (validMove) {
                x = newX;
                y = newY;
            }
        }
        // 새로운 위치 반환하는 과정정
        return new int[]{x, y};
    }
}
