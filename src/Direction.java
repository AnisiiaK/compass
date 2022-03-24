import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        if(degrees ==0 || degrees % 360 == 0){
            return N;
        }
        if(degrees>0) {
            if (degrees % NW.degrees == 0)
                return NW;
            if (degrees % W.degrees == 0)
                return W;
            if (degrees % SW.degrees == 0)
                return SW;
            if (degrees % S.degrees == 0)
                return S;
            if (degrees % SE.degrees == 0)
                return SE;
            if (degrees % E.degrees == 0)
                return E;
            if (degrees % NE.degrees == 0)
                return NE;
        }else{
            if (degrees % NW.degrees == 0)
                return NE;
            if (degrees % E.opposite().degrees == 0)
                return E;
            if (degrees % SW.degrees == 0)
                return SE;
            if (degrees % S.degrees == 0)
                return S;
            if (degrees % SE.degrees == 0)
                return SW;
            if (degrees % W.opposite().degrees == 0)
                return W;
            if (degrees % NE.degrees == 0)
                return NW;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees %= 360;
        if(degrees>0) {
            if (degrees < (N.degrees + NE.degrees) / 2)
                return N;
            if (degrees < (NE.degrees + E.degrees) / 2)
                return NE;
            if (degrees < (E.degrees + SE.degrees) / 2)
                return E;
            if (degrees < (SE.degrees + S.degrees) / 2)
                return SE;
            if (degrees < (S.degrees + SW.degrees) / 2)
                return S;
            if (degrees < (SW.degrees + W.degrees) / 2)
                return SW;
            if (degrees < (W.degrees + NW.degrees) / 2)
                return W;
            return NW;
        }else{
            if (degrees > -(N.degrees + NE.degrees) / 2)
                return N;
            if (degrees > -(NE.degrees + E.degrees) / 2)
                return NW;
            if (degrees > -(E.degrees + SE.degrees) / 2)
                return W;
            if (degrees > -(SE.degrees + S.degrees) / 2)
                return SW;
            if (degrees > -(S.degrees + SW.degrees) / 2)
                return S;
            if (degrees > -(SW.degrees + W.degrees) / 2)
                return SE;
            if (degrees > -(W.degrees + NW.degrees) / 2)
                return E;
            return NE;
        }

    }

    public Direction opposite() {
        switch (this){
            case N: return S;
            case NE: return SW;
            case E: return W;
            case SE: return NW;
            case S: return N;
            case SW: return NE;
            case W: return E;
            case NW: return SE;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        if(this == N && direction.degrees> 180) {
            return Math.abs(360 - direction.degrees);
        }
        if(direction ==N && this.degrees>180){
            return Math.abs(360 - this.degrees);

        }
        return Math.abs(this.degrees - direction.degrees);

        //throw new UnsupportedOperationException();
    }
}
