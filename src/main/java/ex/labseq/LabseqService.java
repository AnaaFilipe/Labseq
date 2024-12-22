package ex.labseq;

import io.quarkus.cache.CacheResult;
//import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@ApplicationScoped
public class LabseqService {

    @CacheResult(cacheName = "labseq-cache")
    public BigInteger getValueRecursive(int n) {
        if (n == 0 || n == 2) {
            return BigInteger.ZERO;
        } else if (n == 1 || n == 3) {
            return BigInteger.ONE;
        } else {
            return getValueRecursive(n - 4).add(getValueRecursive(n - 3));
        }
    }


    @CacheResult(cacheName = "labseq")
    public BigInteger getValueIterative(int n) {
        if (n == 0 || n == 2) {
            return BigInteger.ZERO;
        } else if (n == 1 || n == 3) {
            return BigInteger.ONE;
        }

        BigInteger[] results = new BigInteger[4];
        results[0] = BigInteger.ZERO; // f(0)
        results[1] = BigInteger.ONE; // f(1)
        results[2] = BigInteger.ZERO; // f(2)
        results[3] = BigInteger.ONE; // f(3)

        for (long i = 4; i <= n; i++) {
            BigInteger nextValue = results[0].add(results[1]);
            results[0] = results[1];
            results[1] = results[2];
            results[2] = results[3];
            results[3] = nextValue;
        }
        return results[3];
    }
}
