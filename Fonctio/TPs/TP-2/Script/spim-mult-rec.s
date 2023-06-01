    .data
msg1: .asciiz "Entrez la valeur de x: "
msg2: .asciiz "Entrez la valeur de y: "
endl: .asciiz "\n"

    .text
main:
    addiu       $sp, $sp, -4
    sw          $ra, 0($sp)

    la          $a0, msg1
    li          $v0, 4
    syscall

    li          $v0, 5
    syscall
    move        $t0, $v0 # Get x

    la          $a0, msg2
    li          $v0, 4
    syscall

    li          $v0, 5
    syscall

    move        $a0, $t0 # Get X
    move        $a1, $v0 # Get Y

    jal         mult_rec
    move        $a0, $v0

    li          $v0, 1  # Print result
    syscall

    la          $a0, endl
    li          $v0, 4
    syscall

    lw          $ra, 0($sp)
    addiu       $sp, $sp, 4

    jr          $ra

mult_rec:
    blt		    $a0, $a1, mult_rec_noSwap
    move        $t0, $a0
    move        $a0, $a1
    move        $a1, $t0

mult_rec_noSwap:
    beq         $a0, $zero, mult_rec_base
    addi	    $a0, $a0, -1
    addiu       $sp, $sp, -4
    sw          $ra, 0($sp)
    jal         mult_rec_noSwap
    lw          $ra, 0($sp)
    addiu       $sp, $sp, 4
    add		    $v0, $v0, $a1
    jr          $ra

mult_rec_base:
    li          $v0, 0
    jr          $ra