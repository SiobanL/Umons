# sum= 0;
# pow= 1;

# for (i= 0; i < 5; i++) {
#     sum= sum + pow;
#     pow= pow * 2;
# }

#  i == $t0
#  sum == $t1
#  num == $t2
#  pow == $t3
    .data
sum: .asciiz "Sum: "
pow: .asciiz "Pow: "
space: .asciiz "\n"

    .text
main:
    li      $t0, 0      # init i
    li      $t1, 0      # init sum
    li      $t2, 5      # init num
    li      $t3, 1      # init pow
    li      $t4, 2
    j		for			# jump to for

for:
    beq		$t0, $t2, end_for	# if $t0 == $t2 then goto target
    add		$t1, $t1, $t3		# $t1 = $t1 + $t3
    mult	$t3, $t4   		    # $t0 * 2 = Hi and Lo registers
    mflo	$t3					# copy Lo to $t2
    addi	$t0, $t0, 1			# $t0 = $1 + 1  increment i
    j       for
    
    
end_for:
    la      $a0, sum
    li      $v0, 4
    syscall
    move 	$a0, $t1		# $v0 = $t3
    li      $v0, 1
    syscall
    la      $a0, space
    li      $v0, 4
    syscall
    la      $a0, pow
    li      $v0, 4
    syscall
    move 	$a0, $t3		# $a0 = $t1
    li      $v0, 1
    syscall
    jr		$ra				# jump to $ra