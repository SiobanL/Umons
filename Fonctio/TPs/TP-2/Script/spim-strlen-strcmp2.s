    .data
str1: .asciiz "Je t'aime <3"
str2: .asciiz "Je t aime <3"
comp: .asciiz "\n"
    .text
main:
    # Push
    addiu       $sp, $sp, -4
    sw		    $ra, 0($sp)

    la		    $a0, str1
    la          $a1, str2

    jal         strCmp
    # Pop
    lw		    $ra, 0($sp) 
    addiu       $sp, $sp, 4

    move 	    $a0, $v0
    li		    $v0, 1
    syscall

    jr		    $ra

strCmp:
    lb          $t0, 0($a0)
    lb          $t1, 0($a1)
    blt		    $t0, $t1, less
    bgt		    $t0, $t1, greater
    beq         $t0, $zero, equal
    addiu       $a0, $a0, 1
    addiu       $a1, $a1, 1
    b           strCmp

equal:
    li          $v0, 0
    jr          $ra

less:
    li          $v0, -1
    jr          $ra

greater:
    li          $v0, 1
    jr          $ra
# strlen:
#     li          $v0, 0
#     b		    strloop

# strloop:
#     lb		    $t0, 0($a0)
#     beq		    $t0, $zero, strloop_end
#     addiu       $v0, $v0, 1
#     addiu       $a0, $a0, 1
#     b		    strloop

# strloop_end:
#     jr          $ra
