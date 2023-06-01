    .data
first: .asciiz "Entrez le premier nombre: "
secnd: .asciiz "Entrez le deuxieme nombre: "
reslt: .asciiz "Le resultat est: "
space: .asciiz "\n"
    .text
main:
    # Prompt first
    la      $a0, first
    li      $v0, 4
    syscall

    # Read first number
    li      $v0, 5
    syscall
    move    $t0, $v0

    # Prompt space
    la      $a0, space
    li      $v0, 4
    syscall

    # Prompt second
    la      $a0, secnd
    li      $v0, 4
    syscall

    # Read second number
    li      $v0, 5
    syscall
    move    $t1, $v0

    # Prompt space
    la      $a0, space
    li      $v0, 4
    syscall

    # Prompt result
    la      $a0, reslt
    li      $v0, 4
    syscall

    # Calculate result
    add		$a0, $t0, $t1

    # Prompt result of calcul
    li      $v0, 1
    syscall

    jr      $ra