import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
// no calculation in the constructor, but
// since Lombok 1.18.16, we can cache the hash code
@EqualsAndHashCode(cacheStrategy = EqualsAndHashCode.CacheStrategy.LAZY)

public class Coordinate {
    private final int x;
    private final int y;

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public int distance(Coordinate other) {
        return Math.abs(this.x - other.getX()) + Math.abs(this.y - other.getY());
    }
}