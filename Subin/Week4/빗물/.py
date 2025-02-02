h, w = map(int,(input().split()))
block = list(map(int,input().split()))

rain = 0
left_max = block[0]

#오른쪽 max 고려하기 위해 배열 생성(몰랐던 부분)
right_max = [0]*w
right_max[w-1] = block[w-1]
for x in range(w-2,-1,-1):
    right_max[x] = max(block[x],right_max[x+1])


for i in range(1,w):
    if left_max>block[i]:
        if right_max[i]>left_max: #오른>왼
            rain += left_max- block[i]
        else:
            rain += right_max[i]-block[i]
    if left_max<block[i]:
        left_max = block[i]
print(rain)
