package sepration_of_concern;

import java.util.List;

public class AssetUtil_UsingStream_Version1 {

    private AssetUtil_UsingStream_Version1() {
        throw new UnsupportedOperationException("No Object For Utils..!");
    }

    public static int totalAssetsValue(final List<Asset> assets) {
        return assets.stream()
                    .mapToInt(Asset::getValue)
                    .sum();
    }

    public static int totalAssetsBondValue(final List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getAssetType().equals(Asset.AssetType.BOND))
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalAssetsStockValue(final List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getAssetType().equals(Asset.AssetType.STOCK))
                .mapToInt(Asset::getValue)
                .sum();
    }
}
