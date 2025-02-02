#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int x = 0, y = 0;

    for (int i = 0; i < park.size(); i++) {
        for (int j = 0; j < park[i].size(); j++) {
            if (park[i][j] == 'S') {
                x = i;
                y = j;
                break;
            }
        }
    }

    for (const string& route : routes) {
        char direction = route[0];
        int steps = route[2] - '0';

        int newX = x, newY = y;
        bool isBlocked = false;

        for (int step = 0; step < steps; step++) {
            if (direction == 'E') newY++;
            else if (direction == 'W') newY--;
            else if (direction == 'S') newX++;
            else if (direction == 'N') newX--;

            if (newX < 0 || newX >= park.size() || newY < 0 || newY >= park[0].size() || park[newX][newY] == 'X') {
                isBlocked = true;
                break;
            }
        }

        if (!isBlocked) {
            x = newX;
            y = newY;
        }
    }

    answer.push_back(x);
    answer.push_back(y);
    return answer;
}
