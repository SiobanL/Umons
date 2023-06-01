    .data
tab: .word -17, 5, 9, 22, 123, 1024
srh: .asciiz "Entrez le nombre que vous cherchez: "

    .text
main:
    # Push
    addiu   $sp, $sp, -4
    sw      $ra, 0($sp)

    la      $a0, srh
    li      $v0, 4
    syscall

    li      $v0, 5
    syscall

    # arg of fct
    la      $a0, tab    # Load tab adress
    li      $a1, 6      # Load length of tab
    move    $a2, $v0    # Load search number

    jal     find_int
    move    $a0, $v0

    li      $v0, 1
    syscall

    # Pop
    lw      $ra, 0($sp)
    addiu   $sp, $sp, 4

    jr      $ra

find_int:
    lw      $t0, 0($a0)
    beq		$t0, $a2, equal
    bgt		$t1, $a1, not_in_tab
    addi    $a0, $a0, 4
    addi	$t1, $t1, 1
    j       find_int

equal:
    move    $v0, $t1
    jr      $ra

not_in_tab:
    li      $v0, -1
    jr      $ra