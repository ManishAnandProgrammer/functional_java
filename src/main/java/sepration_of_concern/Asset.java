package sepration_of_concern;

public class Asset {
    public enum AssetType {BOND, STOCK}

    private final AssetType assetType;
    private final Integer value;

    public Asset(final AssetType assetType, final Integer value) {
        this.assetType = assetType;
        this.value = value;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public Integer getValue() {
        return value;
    }
}
