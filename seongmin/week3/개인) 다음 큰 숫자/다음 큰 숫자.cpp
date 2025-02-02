#include <string>
#include <vector>
using namespace std;

vector<int> v;

int makeTwo(int n)
{
    int count = 0;
    while (n != 0)
    {
        if (n % 2 == 1) count++;
        n /= 2;
    }
    return count;
}


int solution(int n) {
    int answer = n;
    int temp = makeTwo(answer);
    answer += 1;
    while (makeTwo(answer) != temp) {
        answer++;
    }

    return answer;
}