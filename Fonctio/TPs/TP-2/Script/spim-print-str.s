    .data
str:    .asciiz "Maxime mon dos c'est tortanke\n"
    .text

main:
    la		$a0, str
    li		$v0, 4
    syscall 
    jr		$ra

# Q12: 6978614d