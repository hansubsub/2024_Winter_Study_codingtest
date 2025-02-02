
function solution(park, routes) {
    const Height = park.length; 
    const Width = park[0].length; 

    // 방향별 이동 
    const moves = {
        N: [-1, 0],
        S: [1, 0],  
        W: [0, -1], 
        E: [0, 1], 
    };

    // 시작 위치 
    let [x, y] = [0, 0]; 
    for (let i = 0; i < Height; i++) {
        for (let j = 0; j < Width; j++) {
            if (park[i][j] === "S") {
                [x, y] = [i, j]; 
                break;
            }
        }
    }

   
    for (const route of routes) {
        const [direction, distanceStr] = route.split(" ");
        const distance = parseInt(distanceStr); 
        const [dx, dy] = moves[direction]; 

        let nx = x;
        let ny = y;
        let valid = true; //이동이 가능한가

        for (let step = 0; step < distance; step++) {
            nx += dx;
            ny += dy;

            // 경계 확인 및 장애물있는지 
            if (nx < 0 || nx >= Height || ny < 0 || ny >= Width || park[nx][ny] === "X") {
                valid = false;
                break;
            }
        }

        // 이동이 가능할때만 위치계산
        if (valid) {
            x = nx;
            y = ny;
        }
    }

    // 최종 위치 반환
    return [x, y];
}
