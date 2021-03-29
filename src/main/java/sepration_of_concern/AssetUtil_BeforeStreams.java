package sepration_of_concern;

import java.util.List;

public class AssetUtil_BeforeStreams {
    private AssetUtil_BeforeStreams() {
        throw new UnsupportedOperationException("No Object For Utils..!");
    }

    public static int totalAssetsValue(final List<Asset> assets) {
        int totalValue = 0;

        for(Asset asset : assets)
            totalValue += asset.getValue();

        return totalValue;
    }

    public static int totalAssetsBondValue(final List<Asset> assets) {
        int totalValue = 0;

        for(Asset asset : assets)
            if(asset.getAssetType().equals(Asset.AssetType.BOND))
                totalValue += asset.getValue();

        return totalValue;
    }

    public static int totalAssetsStockValue(final List<Asset> assets) {
        int totalValue = 0;

        for(Asset asset : assets)
            if(asset.getAssetType().equals(Asset.AssetType.STOCK))
                totalValue += asset.getValue();

        return totalValue;
    }
}
