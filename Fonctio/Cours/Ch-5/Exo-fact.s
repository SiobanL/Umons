    .data
ask: .asciiz "Enter a number to factor it: "
rst: .asciiz "!=  "
    .text
main:
    # Prompt ask
    la      $a0, ask
    li      $v0, 4
    syscall

    # Read number to factor
    li      $v0, 5
    syscall
    move    $t0, $v0        # placed temp

    # Prompt number
    move    $a0, $t0        # place for print arg
    li      $v0, 1
    syscall

    # Prompt rst
    la      $a0, rst
    li      $v0, 4
    syscall

    # Place fct arg
    move    $a0, $t0        # place for fct arg

    # add $ra on stack
    addiu   $sp, $sp, -4
    sw		$ra, 0($sp)

    # Goto recurse fct
    jal		fact		    # jump to fact and save position to $ra
    
    # POP from stack for $ra
    lw		$ra, 0($sp)
    addiu   $sp, $sp, 4
    
    # Print result
    move 	$a0, $v0        # move to fct arg
    li      $v0, 1
    syscall
    jr      $ra

fact:
    li      $s0, 1
    bgt		$a0, $s0, fact_recurse	   # if $t0 > $t1 then goto fact_recurse
    li      $v0, 1
    jr		$ra					       w# jump to $ra

fact_recurse:
    addiu   $sp, $sp, -8
    sw      $a0, 0($sp)
    sw      $ra, 4($sp)
    addi    $a0, $a0, -1
    jal     fact
    lw		$a0, 0($sp)
    lw      $ra, 4($sp)
    addiu   $sp, $sp, 8
    mult    $v0, $a0
    mflo    $v0
    jr      $ra