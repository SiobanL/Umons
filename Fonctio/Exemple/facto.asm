main:
    addi		$v0, $0, 1		# system call #1 - print int
    add		$a0, $0, 4
    syscall						# execute

fact:
    li		$s0 ,1
    bgt	    $a0, $s0, fact_recurse
    li      $v0, 1
    jr		$ra

fact_recurse:
    adiu    $sp, $sp, -8
    sw      $a0, 0($sp)
    sw      $ra, $a0, -1
    addi	$a0, $a0, -1
    jal		fact
    lw		$a0, 0($sp)
    lw      $ra, 4($sp)
    addiu   $sp, $sp, 8
    mult	$v0, $a0
    mflo	$v0
    jr      $ra

# PUSH :
# adiu $sp, $sp, -4
# sw $ra, o($sp)

# POP:
# li $ra, 0($sp)
# adiu $sp, $sp, 4