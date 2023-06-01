    .text
main:
    # Update $sp
    addiu       $sp, $sp, -12
    # Push $ra on stack
    sw		    $ra, 0($sp)

    # Call fct mult6
    # Load 4 arg of mul6 is reg $a0, ..., $a3
    li          $a0, 1      # arg 1
    li          $a1, 2      # arg 2
    li          $a2, 3      # arg 3
    li          $a3, 4      # arg 4
    # Load other arg on stack  
    li          $t0, 5  
    sw          $t0, 4($sp) # arg 5
    li          $t0, 6
    sw          $t0, 8($sp) # arg 6

    jal		    mul6

    # Pop $ra on stack
    lw		    $ra, 0($sp)
    addiu       $sp, $sp, 12

    move        $a0, $v0
    li          $v0, 1
    syscall

    jr          $ra

mul6:
    mult	    $a0, $a1
    mflo	    $v0    
    mult	    $v0, $a2
    mflo	    $v0
    mult	    $v0, $a3
    mflo	    $v0

    lw          $a0, 4($sp)
    mult        $v0, $a0
    mflo        $v0

    lw          $a0, 8($sp)
    mult        $v0, $a0
    mflo        $v0

    jr          $ra 