	.text
main:
	li	$a0, 4
	addiu	$sp, $sp, -4
	sw	$ra, 0($sp)
	jal	fact
	lw	$ra, 0($sp)
	addiu	$sp, $sp, 4
	move	$a0, $v0
	li	$v0, 1
	syscall
	jr	$ra

fact:
	li	$s0, 1
	bgt	$a0, $s0, fact_recurse
	li	$v0, 1
	jr	$ra
fact_recurse:
	addiu	$sp, $sp, -8
	sw	$a0, 0($sp)
	sw	$ra, 4($sp)
	addi	$a0, $a0, -1
	jal	fact
	lw	$a0, 0($sp)
	lw	$ra, 4($sp)
	addiu	$sp, $sp, 8
	mult	$v0, $a0
	mflo	$v0
	jr	$ra
