    .data
hex: .asciiz "0123456789ABCDEF"
msg: .asciiz "Entrez un nombre: "
spc: .asciiz "\n"

    .text
main:
    la      $a0, msg
    li      $v0, 4
    syscall

    li      $v0, 5
    syscall

    la      $a2, hex

    bne     $v0, $zero, non_zero
    li      $a0, 0
    li      $v0, 1
    syscall
    j		end

non_zero:
    li      $a0, 16
    div		$v0, $a0
    mflo	$a1
    mfhi	$a0
    
    add		$a0, $a0, $a2
    lb		$a0, 0($a0)
    li      $v0, 11
    syscall

    move    $v0, $a1
    bne     $v0, $zero, non_zero

end:
    la      $a0, spc
    li      $v0, 4
    syscall
    jr      $ra