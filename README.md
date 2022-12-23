# class23-12
## kata task1
[Task link]()    
My solution
```java
import java.util.Arrays;

public class Kumite {
    public static boolean block(int[] attackers, int[] defenders) {
        int survivorsCount = 0;

        int lengthDiff = attackers.length - defenders.length;

        for (int i = 0; i < Math.min(attackers.length, defenders.length); i++) {
            if (attackers[i] - defenders[i] < 0) {
                survivorsCount += 1;
            } else if (attackers[i] - defenders[i] > 0) {
                survivorsCount -= 1;
            }
        }

        if (lengthDiff < 0) {
            survivorsCount += Math.abs(lengthDiff);
        } else {
            survivorsCount -= lengthDiff;
        }

        int damage = Arrays.stream(attackers).sum() - Arrays.stream(defenders).sum();

        if (survivorsCount < 0) {
            return false;
        } else if (survivorsCount > 0) {
            return true;
        } else if (damage > 0) {
            return false;
        }

        return true;
    }
}
```
My fav solution
```java
import static java.util.stream.IntStream.of;

interface Kumite {
  static boolean block(int[] attackers, int[] defenders) {
    int survived = defenders.length - attackers.length;
    for (int i = 0; i < Math.min(defenders.length, attackers.length); i++) {
      survived += Math.signum(defenders[i] - attackers[i]);
    }
    return survived > 0 || survived == 0 && of(defenders).sum() >= of(attackers).sum();
  }
}
```
