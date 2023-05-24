# a = b - c
# d = (a+e) - (f+g)
#
# a == $t0
# b == $a0
# c == $a1
# d == $v0
# e == $s1
# f == $s2
# g == $s3
    .text
main:
    sub     $t0, $a0, $a1        # a = b -c
    add     $t1, $t0, $s1        # $t1 = (a+e)
    add     $t2, $s2, $s3        # $t2 = (f+g)
    sub     $v0, $t1, $t2        # d = $t1 - $t2
    jr		$ra					# jump to $ra
    