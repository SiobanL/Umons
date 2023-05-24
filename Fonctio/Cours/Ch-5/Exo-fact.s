main:
    li		$a0, 5	        # $a0 = 5   n in fct fact
    addiu   $sp, $sp, -4
    sw		$ra, 0($sp)
    jal		fact		    # jump to fact and save position to $ra
    
    # POP from stack for $ra
    lw		$ra, 0($sp)
    addiu   $sp, $sp, 4
    # Print result
    move 	$a0, $v0
    li      $v0, 1
    syscall
    jr      $ra

fact:
    li      $s0, 1
    bgt		$a0, $s0, fact_recurse	# if $t0 > $t1 then goto target
    li      $v0, 1
    jr		$ra					    # jump to $ra

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