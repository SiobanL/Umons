    .data
msg: .asciiz "Hello world fct!"
    .text
main:
    addiu   $sp, $sp, -4
    sw		$ra, 0($sp)
    jal		fct
    lw		$ra, 0($sp)
    addiu   $sp, $sp, 4
    jr      $ra

fct:
    la      $a0, msg
    li      $v0, 4
    syscall

    jr      $ra
