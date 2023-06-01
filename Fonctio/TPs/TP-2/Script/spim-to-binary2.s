    .data
endl: .asciiz "\n"
    
    .text
main:
    li      $v0, 5
    syscall
    move    $a1, $v0

    li      $a2, 1
    li      $a3, 31
    sll     $a2, $a2, $a3

loop:
    and     $a3, $a1, $a2
    bne     $a3, $zero, is_one

is_zero:
    li      $a0, 0
    b       print_int

is_one:
    li      $a0, 1

print_int:
    li      $v0, 1 # print_int
    syscall

    srl     $a2, $a2, 1
    bne     $a2, $zero, loop
    la      $a0, endl
    li      $v0, 4
    syscall
    jr      $ra
