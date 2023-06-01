    .data
msg: .asciiz "Entrez un nombre: "
spc: .asciiz "\n"
    .text
main:
    # Prompt msg
    la		$a0, msg
    li      $v0, 4
    syscall

    # Read int
    li      $v0, 5
    syscall
    move 	$a1, $v0

    # Convert number
    bne		$a1, $zero, non_zero
    li      $v0, 1
    li      $a0, 0
    syscall
    b		end

non_zero:
    andi    $a0, $a1, 1
    li      $v0, 1
    syscall
    li      $a2, 1
    srl     $a1, $a1, $a2
    bne     $a1, $zero, non_zero

end:
    la      $a0, spc
    li      $v0, 4
    syscall

    jr		$ra