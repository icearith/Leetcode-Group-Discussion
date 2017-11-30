
public class VersionControl {
    public static int firstBad=0;

    protected boolean isBadVersion(int version) {
        System.out.println(version);
        if (version >= firstBad)
            return true;
        return false;
    }
}