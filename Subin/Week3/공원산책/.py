def solution(park, routes):
    size = [len(park), len(park[0])]
    resultH, resultW = 0, 0
    
    # 시작위치 [H, W]
    for i in range(size[0]):
        for j in range(size[1]):
            if park[i][j] == "S":
                resultH = i
                resultW = j
                break
    
    # 이동 수 = x            
    for x in range(len(routes)):
        H = resultH
        W = resultW
        direc, step = routes[x].split()
        step = int(step)
        
        if direc == "E":
            # 1씩 움직이며 확인 
            for e in range(step):
                if W + (e + 1) > size[1] - 1 or park[H][W + (e + 1)] == "X":
                    break
            else: #for - else 문 유의!!!
                resultW += step  

        elif direc == "W":
            # 1씩 움직이며 확인 
            for w in range(step):
                if W - (w + 1) < 0 or park[H][W - (w + 1)] == "X":
                    break
            else:
                resultW -= step  

        elif direc == "S":
            # 1씩 움직이며 확인 
            for s in range(step):
                if H + (s + 1) > size[0] - 1 or park[H + (s + 1)][W] == "X":
                    break
            else:
                resultH += step  

        elif direc == "N":
            # 1씩 움직이며 확인 
            for n in range(step):
                if H - (n + 1) < 0 or park[H - (n + 1)][W] == "X":
                    break
            else:
                resultH -= step  
    return [resultH, resultW]
