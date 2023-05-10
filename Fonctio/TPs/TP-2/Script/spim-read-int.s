    .data
more: .asciiz "Trop grand\n"
equal: .asciiz "Valeur acceptée\n"
default: .asciiz "Entrez un nombre: "
    .text

main:
    la      $a0, default
    li      $v0, 4
    syscall

while:
    li      $v0, 5
    syscall
    bgt		$v0, 10 , bad	    # if $t0 > 10 then goto bad
    bge		$v0, 0  , good	    # if $t0 >= 0 then goto good
    jr      $ra

bad:
    la      $a0, more
    li      $v0, 4
    syscall
    j		while				# jump to while

good:
    la      $a0, equal
    move 	$t0, $v0		    # $v0 = a0
    li      $v0, 4
    syscall
    move    $a0, $t0
    li      $v0, 1
    syscall
    j       while