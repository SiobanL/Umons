    .data
says: .asciiz "Enter two nunbers\nFirst: "
second: .asciiz "Second: "
result: .asciiz "The result is: "
    .text

main:
    la      $a0, says
    li      $v0, 4
    syscall
    # write two's first line.
    li      $v0, 5
    syscall
    # load first data in $v0
    move 	$t0, $v0
    # move data into $t0
    la      $a0, second
    li      $v0, 4
    syscall
    # write third line
    li      $v0, 5
    syscall
    # load second data
    move    $t1, $v0
    # move data into $t1
    add		$t2, $t0, $t1
    # add in $t2, $t0, $t1
    la      $a0, result
    li      $v0, 4
    syscall
    # write result
    move    $a0, $t2
    li      $v0, 1
    syscall
    #write result of $t0+$t1 who is in $t2
    jr      $ra