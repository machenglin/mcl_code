def gcd(p, q):
    if q == 0:
        return p
    r = p % q
    return gcd(q, r)

print gcd(6, 8)
print gcd(12, 8)
