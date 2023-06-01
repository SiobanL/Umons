    .data
jump_table: 
    .word case5, case6, case7, case8

msg: .asciiz "Entrez un nombre: "
msg_case5: .asciiz "Cas 5\n"
msg_case6: .asciiz "Cas 6\n"
msg_case7: .asciiz "Cas 7\n"
msg_case8: .asciiz "Cas 8\n"
msg_default: .asciiz "Cas par defaut\n"

    .text
main:
    la      $a0, msg
    li      $v0, 4
    syscall

    li      $v0, 5
    syscall

    li      $a0, 5
    blt		$v0, $a0, end_case
    li      $a0, 8
    bgt		$v0, $a0, end_case
    
    la      $t2, jump_table
    addiu   $v0, $v0, -5
    sll     $v0, $v0, 2
    add     $t0, $t2, $v0
    lw      $t2, 0($t0)
    jr      $t2 

case5:
    la      $a0, msg_case5
    li      $v0, 4
    syscall
    j       end_case

case6:
    la      $a0, msg_case6
    li      $v0, 4
    syscall
    j       end_case

case7:
    la      $a0, msg_case7
    li      $v0, 4
    syscall
    j       end_case

case8:
    la      $a0, msg_case8
    li      $v0, 4
    syscall
    j       end_case

case_default:
    la      $a0, case_default
    li      $v0, 4
    syscall
    j       end

end_case:
    j       main

end:
    jr      $ra