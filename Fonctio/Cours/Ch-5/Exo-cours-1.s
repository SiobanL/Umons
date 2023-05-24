    .text
main:
    li      $a0, 9
    li      $a1, 0xFFFFFFFC
    add     $t0, $a0, $a1
    mult    $t0, $t0
    mflo    $v0
    li      $v0, 4
    syscall
    jr      $ra

    # memory adresse out of bound