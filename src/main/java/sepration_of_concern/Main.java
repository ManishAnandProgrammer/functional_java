package sepration_of_concern;

import java.util.List;

public class Main {

    final static List<Asset> assets =
            List.of(new Asset(Asset.AssetType.BOND, 2000),
                    new Asset(Asset.AssetType.BOND, 3000),
                    new Asset(Asset.AssetType.BOND, 5000),
                    new Asset(Asset.AssetType.STOCK, 2000),
                    new Asset(Asset.AssetType.STOCK, 3000),
                    new Asset(Asset.AssetType.STOCK, 5000));

    public static void main(String[] args) {
        calculateTotalInPreFunctionalWay();
        calculateTotalInStreamVersion1();
        calculateTotalInStreamVersionFinal();
    }

    public static void calculateTotalInPreFunctionalWay() {
        System.out.println("Total Assets:: "+ AssetUtil_BeforeStreams.totalAssetsValue(assets));
        System.out.println("Total Bond Assets:: "+ AssetUtil_BeforeStreams.totalAssetsBondValue(assets));
        System.out.println("Total Stock Assets:: "+ AssetUtil_BeforeStreams.totalAssetsStockValue(assets));
    }

    public static void calculateTotalInStreamVersion1() {
        System.out.println("Stream Version 1 Total Assets:: "+ AssetUtil_UsingStream_Version1.totalAssetsValue(assets));
        System.out.println("Stream Version 1 Total Bond Assets:: "+ AssetUtil_UsingStream_Version1.totalAssetsBondValue(assets));
        System.out.println("Stream Version 1 Total Stock Assets:: "+ AssetUtil_UsingStream_Version1.totalAssetsStockValue(assets));
    }

    public static void calculateTotalInStreamVersionFinal() {
        System.out.println("Stream Version Final Total Assets:: "+
                AssetUtil_UsingStream_Final.totalAssetsValue(assets, asset -> true));
        System.out.println("Stream Version Final Total Bond Assets:: "+
                AssetUtil_UsingStream_Final.totalAssetsValue(assets, asset -> asset.getAssetType().equals(Asset.AssetType.BOND)));
        System.out.println("Stream Version Final Total Stock Assets:: "+
                AssetUtil_UsingStream_Final.totalAssetsValue(assets, asset -> asset.getAssetType().equals(Asset.AssetType.STOCK)));
    }

}
