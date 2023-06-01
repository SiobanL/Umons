    .data
msg1: .asciiz "Entrez un naturel:\n"
hex: .asciiz "0123456789ABCDEF"
endl: .asciiz "\n"

    .text
main:
    la          $a0, msg1
    li          $v0, 4
    syscall

    li          $v0, 5
    syscall

    la          $a2, hex

    bne         $v0, $zero, non_zero
    li          $a0, 0
    li          $v0, 1
    syscall
    j           end

non_zero:
    li          $a0, 16
    div         $v0, $a0
    mfhi        $a0 # reste
    mflo        $a1 # quotient

    add         $a0, $a0, $a2
    lb          $a0, 0($a0)
    li          $v0, 11 # print_char
    syscall

    move         $v0, $a1
    bne         $v0, $zero, non_zero

end:
    la          $a0, endl
    li          $v0, 4
    syscall
    jr          $ra