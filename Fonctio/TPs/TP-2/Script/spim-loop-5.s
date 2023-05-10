main:
    li $a0, 5
    li $a1, 0
    j while

while:
    addi $a1, $a1, 1
    bne $a0, $a1, while
    jr  $ra