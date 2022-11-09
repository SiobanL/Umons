def produit_matriciel(A, B):
    if len(A[0]) != len(B):
        return
    
    C = []
    for i in range(len(A)):
        C.append([])

    for i in range(len(A)):
        for j in range(len(B[0])):
            sum = 0
            for k in range(len(A[0])):
                sum += A[i][k] * B[k][j]
            C[i].append(sum)
    
    return C

print(produit_matriciel([[2, 0, 1], [3, 6, 2]], [[1, 5], [2, 6], [3, 7]]))







