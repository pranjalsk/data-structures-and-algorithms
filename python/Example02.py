# Example 02
# @author Pranjal Karankar
# @version -- Python 2.7
# -*- coding: utf-8 -*-

from numpy import array_equal
from numpy import asarray
from numpy import zeros
from numpy import inf

STOCK_PRICES = [100, 113, 110, 85, 105, 102, 86, 63,
                81, 101, 94, 106, 101, 79, 94, 90, 97]
STOCK_PRICE_CHANGES = [13, -3, -25, 20, -3, -16, -23,
                       18, 20, -7, 12, -5, -22, 15, -4, 7]


# Implement pseudocode from the book
def find_maximum_subarray_brute(A, low=0, high=-1):

    vmax = A[0]
    for i in range(0, len(A) - 1):
        temp_sum = 0
        for j in range(i, len(A) - 1):
            temp_sum = temp_sum + A[j]
            if temp_sum > vmax:
                low = i
                high = j
                vmax = temp_sum
    return vmax, low, high


# Implement pseudocode from the book
def find_maximum_crossing_subarray(A, low, mid, high):

    left_sum = - inf
    sum = 0
    leftindex = 0
    rightindex = 0

    for i in range(mid, low - 1, -1):
        sum = sum + A[i]
        if sum > left_sum:
            left_sum = sum
            leftindex = i

    right_sum = - inf
    sum = 0
    for j in range(mid + 1, high + 1, 1):
        sum = sum + A[j]
        if sum > right_sum:
            right_sum = sum
            rightindex = j

    return leftindex, rightindex, left_sum + right_sum


def find_maximum_subarray_recursive(A, low=0, high=-1):

    if high == low:
        return low, high, A[low] - 1
    else:
        mid = (low + high) / 2
        L = find_maximum_subarray_recursive(A, low, mid)
        R = find_maximum_subarray_recursive(A, mid + 1, high)
        C = find_maximum_crossing_subarray(A, low, mid, high)
        (left_low, left_high, left_sum) = L
        (right_low, right_high, right_sum) = R
        (cross_low, cross_high, cross_sum) = C

        if left_sum >= right_sum and left_sum >= cross_sum:
            return left_sum, left_low, left_high
        elif right_sum >= left_sum and right_sum >= cross_sum:
            return right_sum, right_low, right_high
        else:
            return cross_sum, cross_low, cross_high


def find_maximum_subarray_iterative(A, low=0, high=-1):

    current_max_sum = A[0]
    vmax = A[0]

    for i in range(0, len(A)):
        if A[i] > A[i] + current_max_sum:
            current_max_sum = A[i]
            low = i
        else:
            current_max_sum = A[i] + current_max_sum

        if current_max_sum > vmax:
            vmax = current_max_sum
            high = i
    return vmax, low, high


def square_matrix_multiply(a, b):

    a = asarray(a)
    b = asarray(b)
    assert a.shape == b.shape
    assert a.shape == a.T.shape

    c = zeros((len(a), len(a)))
    for i in range(0, len(a)):
        for j in range(0, len(b)):
            for k in range(0, len(a)):
                c[i][j] = c[i][j] + a[i][k] * b[k][j]
    return c


def square_matrix_multiply_strassens(A, B):

    A = asarray(A)
    B = asarray(B)
    assert A.shape == B.shape
    assert A.shape == A.T.shape
    assert (len(A) & (len(A) - 1)) == 0, "A is not a power of 2"

    n = len(A)
    c = zeros((n, n))
    m = n / 2
    if (n == 1):
        c[0][0] = A[0][0] * B[0][0]
    else:
        a, c, b, d = A[:m, :m], A[m:, :m], A[:m, m:], A[m:, m:]
        e, g, f, h = B[:m, :m], B[m:, :m], B[:m, m:], B[m:, m:]

        s1 = f - h
        s2 = a + b
        s3 = c + d
        s4 = g - e
        s5 = a + d
        s6 = e + h
        s7 = b - d
        s8 = g + h
        s9 = a - c
        s10 = e + f

        p1 = square_matrix_multiply_strassens(a, s1)
        p2 = square_matrix_multiply_strassens(s2, h)
        p3 = square_matrix_multiply_strassens(s3, e)
        p4 = square_matrix_multiply_strassens(d, s4)
        p5 = square_matrix_multiply_strassens(s5, s6)
        p6 = square_matrix_multiply_strassens(s7, s8)
        p7 = square_matrix_multiply_strassens(s9, s10)

        r = p5 + p4 - p2 + p6
        s = p1 + p2
        t = p3 + p4
        u = p5 + p1 - p3 - p7

        c = zeros((n, n))
        for i in range(m):
            for j in range(m):
                c[i][j] = r[i][j]
                c[i][j + m] = s[i][j]
                c[i + m][j] = t[i][j]
                c[i + m][j + m] = u[i][j]
    return c


def test():
    print "Given stock prices-------------------"
    print STOCK_PRICES
    print "Maximum subarray using brute force (sum, low, high)-------------------------"
    print find_maximum_subarray_brute(STOCK_PRICE_CHANGES)
    print "Maximum subarray using iterative (sum, low, high)----------------------------"
    print find_maximum_subarray_iterative(STOCK_PRICE_CHANGES)
    print "Maximum subarray using recursive (sum, low, high)----------------------------"
    SPC = STOCK_PRICE_CHANGES
    print find_maximum_subarray_recursive(SPC, 0, len(SPC) - 1)
    print "-------------Matrix Multiplication----------------"
    A = [[1, 2, 8, 5], [3, 4, 0, -3], [2, -9, -8, -7], [1, 3, -8, 5]]
    A = asarray(A)
    print "Matrix A--->"
    print A
    B = [[5, 6, 0, -1], [7, -1, -7, -6], [1, 4, -9, 3], [2, -1, 8, -3]]
    B = asarray(B)
    print "Matrix B--->"
    print B
    print "Matrix multiplication by brute force"
    print square_matrix_multiply(A, B)
    x = asarray(square_matrix_multiply(A, B))
    print "Matrix multiplication by strassens"
    print square_matrix_multiply_strassens(A, B)
    y = asarray(square_matrix_multiply_strassens(A, B))
    if array_equal(x, y):
        print "both matrix matched"
    pass

if __name__ == '__main__':
    test()
