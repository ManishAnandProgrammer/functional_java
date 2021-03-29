package sepration_of_concern;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtil_UsingStream_Final {

    private AssetUtil_UsingStream_Final() {
        throw new UnsupportedOperationException("No Object For Utils..!");
    }

    public static int totalAssetsValue(final List<Asset> assets,
                                       final Predicate<Asset> assetPredicate) {
        return assets.stream()
                    .filter(assetPredicate)
                    .mapToInt(Asset::getValue)
                    .sum();
    }

}
